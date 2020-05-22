import java.awt.event.*;
import javax.swing.*;

public class KeyBindings extends Box{
    public KeyBindings(){
        super(BoxLayout.Y_AXIS);
        final JTextPane textArea = new JTextPane();
        textArea.insertComponent(new JLabel("Text"));
        add(textArea);

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("New Text");
            }};
         String keyStrokeAndKey = "control SPACE";
         KeyStroke keyStroke = KeyStroke.getKeyStroke(keyStrokeAndKey);
         textArea.getInputMap().put(keyStroke, keyStrokeAndKey);
         textArea.getActionMap().put(keyStrokeAndKey, action);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new KeyBindings());
        frame.pack();
        frame.setVisible(true);
    }
}