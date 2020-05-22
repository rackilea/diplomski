public class TestState implements State<TestAction> {...}
public class TestAction implements Action<TestState> {...}
public static void main(String[] args) {
    TestState initialState = new TestState("1");
    Collection<TestState> allSuccessorStates = getAllSuccessorStates(initialState);
    for (TestState state: allSuccessorStates){
        System.out.println(state.getStateStr());
    }
}