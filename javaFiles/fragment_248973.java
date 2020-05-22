public interface State{}
public interface System<S> {
    S currentState();
}

public interface UpdateableState<S> extends State {
    S update();
}
public interface UpdateableSystem<S> extends System<S> {
    S update();
}

public interface Context{}
public interface ContextState<C, S> extends UpdateableState<S> {
    S updateWithContext(C context);
}
public interface ContextSystem<C, S> extends UpdateableSystem<S> {
    S updateWithContext(C context);
}

public class ExampleContext implements Context{}
public class ExampleContextState implements ContextState<ExampleContext, ExampleContextState>{
    @Override
    public ExampleContextState updateWithContext(ExampleContext context)
    {
        return this;
    }

    @Override
    public ExampleContextState update()
    {
        return this;
    }
}
public class ExampleContextSystem implements ContextSystem<ExampleContext, ExampleContextState>{
    private ExampleContextState currentState;
    public ExampleContextSystem(){
        currentState = new ExampleContextState();
    }
    @Override
    public ExampleContextState updateWithContext(ExampleContext context)
    {
        this.currentState = currentState.updateWithContext(context);
        return currentState;
    }

    @Override
    public ExampleContextState update()
    {
        this.currentState = currentState.update();
        return currentState;
    }

    @Override
    public ExampleContextState currentState()
    {
        return currentState;
    }

}