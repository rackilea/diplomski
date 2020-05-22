public interface State{}
public interface System<S extends State> {
    S currentState();
}

public interface UpdateableState<S extends UpdateableState<S>> extends State {
    S update();
}
public interface UpdateableSystem<S extends UpdateableState<S>> extends System<S> {
    S update();
}

public interface Context{}
public interface ContextState<C extends Context, S extends ContextState<C, S>> extends UpdateableState<S> {
    S updateWithContext(C context);
}
public interface ContextSystem<C extends Context, S extends ContextState<C, S>> extends UpdateableSystem<S> {
    // Some methods here that require SystemContext type
}

class CarContext implements Context {...}
interface CarState extends ContextState<CarContext, CarState> {...}
class CarDrivingState implements CarState {}
class CarIdleState implements CarState {}
class Car implements ContextSystem<CarContext, CarState> {...}