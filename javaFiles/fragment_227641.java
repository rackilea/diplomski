import javax.swing.JFrame;

public class SecondClass {

public JFrame newWindow () {
    JFrame jf = new JFrame ("Text Window");
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setSize(500, 500);
    return jf;
}