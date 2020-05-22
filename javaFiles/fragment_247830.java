public class TTT2 {
    public class State{ // <- non-static
    }
    public static void main(String[] args) {
        State s=new State(); // <- static context
    }
}