public enum LocationEnum {
  HOME, PARK, POND, FOREST
}

public interface StateFactory<StateType extends State> {
  State<StateType> create(Animal<StateType, ?> animal, Context context);
}

// Do stuff Dogs do.
public class DogStateFactory<DogState> {
  public State<DogState> create(Animal<DogState, ?>, Context context) {
    if(context.currentAnimalLocation==LocationEnum.POND) {
      return new IgnoreEverythingState();
    }else if(context.currentAnimalLocation==LocationEnum.HOME){
      return new PerpetualBarkState();
    }else {
      return new FollowEveryCatState();
    }
  }
}

public class Animal<RequestType extends Request, StateType extends State> {
  private StateFactory<StateType> stateFactory;
  private State<StateType> currentState_;

  public void sendRequest(Request<RequestType> request) {
    request.sendToState(currentState_);
  }

  // A specific animal knows what it wants to do, depending on it's current
  // state and it's situational context. We don't want other animals
  // to set the state for us.
  public void determineState() {
    currentState_ = stateFactory.create(this, new Context(...));
    // One might want to extend the messaging stuff in a way that
    // the World instance can log this state change.
  }
}

public class Dog extends Animal<DogRequest, DogState> {
  public Dog() {
    this.stateFactory = new DogStateFactory<DogState>();
  }
}