import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class TextField extends JFrame {

        JTextArea inputField;
        JButton    submit;

        public TextField()
        {
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                inputField = new JTextArea("hi");
                submit = new JButton("Submit");
                inputField.addKeyListener(new KeyListener() {

                        @Override
                        public void keyPressed(KeyEvent arg0) {
                                //func(arg0);
                        }

                        @Override
                        public void keyReleased(KeyEvent arg0) {
                                func(arg0);
                        }

                        @Override
                        public void keyTyped(KeyEvent arg0) {
                                //func(arg0);
                        }
                });
                this.setLayout(new GridLayout(0,1));
                this.add(inputField);
                this.add(submit);
                this.pack();
                this.setVisible(true);
        }

        void func(KeyEvent arg0)
        {
            System.out.println(inputField.getText() + "length: " + inputField.getText().trim().length()); // test input
            if(inputField.getText().trim().length() == 0)
                submit.setEnabled(false);

            if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
                if(inputField.getText().trim().length() == 0)
                        System.out.println("error");
                else
                    System.out.println("success");
                return;
            }
            if(inputField.getText().trim().length() > 0) {
                submit.setEnabled(true);
            }
        }

        public static void main(String [] args)
        {
                new TextField();
        }
}