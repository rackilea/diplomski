public class FirstClass {

public static void main (String [] args) {

    SecondClass sc = new SecondClass ();
    ThirdClass tc = new ThirdClass ();

    JFrame frame = sc.newWindow ();
    JLabel label = tc.newText ();
    frame.add(label);
}

}