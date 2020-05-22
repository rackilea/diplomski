import javax.swing.JOptionPane;

public class greeter
{
    public void sayhello()
    {
        //System.out.println("Hello, World!");
        JOptionPane.showMessageDialog(null, "Hello, World!", 
"greeter", JOptionPane.INFORMATION_MESSAGE);
    }
}