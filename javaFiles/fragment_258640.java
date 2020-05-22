import java.util.Stack;

public class HanoiState {
    Stack<Integer>[] rods;

    public HanoiState(int numOfRods){
        this.rods = (Stack<Integer>[]) new Stack[numOfRods];
    }
}