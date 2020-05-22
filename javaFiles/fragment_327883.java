public class World implements StateChangeListener {
  private Animal dog_;
  private Animals cats_;

  private final List<StateChangeListener> listeners = new ArrayList<StateChangeListener>();

  public World() {
    listeners.add(this);
  }

  // Instead of sending DogRequests to Dogs via the sendDogRequest method:
  public <RequestType extends Request> void sendRequest(
      Animal<RequestType, ?> animal, Request<RequestType> request) {
    animal.sendRequest(request);
    for(StateChangeListener listener : listeners) {
      listener.stateChanged(animal, request);
    }
  }

  public void stateChanged(Animal<?, ?> animal, State<?> state) {
    // ... log here ...
  }
...