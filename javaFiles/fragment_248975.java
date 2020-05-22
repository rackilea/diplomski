public class GenericSystem<S extends UpdateableState<S>> implements UpdateableSystem<S>{
    private S currentState;
    public GenericSystem(S startingState){
        this.currentState = startingState;
    }
    @Override
    public S update()
    {
        this.currentState = currentState.update();
        return currentState;
    }

    @Override
    public S currentState()
    {
        return currentState;
    }

}