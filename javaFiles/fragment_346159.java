public interface Action<E extends State<?>> {
    public E execute(E state);  
}
public interface State<E extends Action<?>> {
    public Collection<E> getPossibleActions();
}
public static <A extends Action<S>, S extends State<A>> Collection<S> getAllSuccessorStates(S state){
    Collection<S> allSuccessors = new HashSet<>();
    for (A localAction: state.getPossibleActions()){
        S successorState = localAction.execute(state);
        allSuccessors.add(successorState);
        allSuccessors.addAll(getAllSuccessorStates(successorState));
    }
    return allSuccessors;
}