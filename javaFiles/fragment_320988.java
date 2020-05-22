public class TicTacToe {
    private String name;        

    // Default constructor.
    public TicTacToe() {
        this("TicTacToe"); // Call the constructor below.
    }

    // Overloaded constructor (polymorphism)
    public TicTacToe(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        new TicTacToe();          // Call default:  "TicTacToe"
        new TicTacToe("My Name"); // Call overload: "My Name"
    }
}