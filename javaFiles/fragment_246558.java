import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class ClassEditor implements ActionListener {

    private ClassMain classMain;

    public ClassEditor(ClassMain classMain) {
        this.classMain = classMain;
        classMain.setLabel("Click the button for a random number!");
    } 

    public JButton getButton() {
        JButton button = new JButton("Click me!");
        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent event) {
        int i = (int) (Math.random()*10);
        classMain.setLabel("Random Number: "+i);
    }

}