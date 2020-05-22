public class Algorithm {
//a lot of code
}
public class MainClass {
    public static void main(...) {
        Algorithm algorithm = new Algorithm();
        GUI g = new GUI(algorithm );
    }
}
public class GUI extends JFrame implements ActionListener {
    private Algorithm algo;
    public GUI(Algorithm a) { this.algo = a; }
}