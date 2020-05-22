import javax.swing.*;

public class CallApplet extends JApplet {

    JTextField output;

    public void init() {
        output = new JTextField(20);
        add(output);
        validate();
    }

    public void setMessage(String message) {
        output.setText(message);
    }
}