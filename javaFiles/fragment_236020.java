public class Example extends JFrame {

    private String redirectedForm = "RedirectedForm";
    private String windowClosing = "WindowClosing";

    Example() {

        CardLayout cl = new CardLayout();
        getContentPane().setLayout(cl);
        add(new WindowClosing(), windowClosing);
        add(new RedirectedForm(), redirectedForm);

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {

                int a = JOptionPane.showConfirmDialog(Example.this, "Did you complete your task?");
                if (a == JOptionPane.CANCEL_OPTION) {
                    return;
                }
                if (a == JOptionPane.NO_OPTION) {
//                  cl.next(frame.getContentPane()); // This to show the next card
                    cl.show(getContentPane(), redirectedForm); // This is to show a specified card
                }
                else {
                    dispose();
                }
            }
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String args[]) {

        new Example();
    }
}

class WindowClosing extends JPanel {

    public WindowClosing() {

        JLabel closeLabel = new JLabel("The WindowClosing panel");
        add(closeLabel);
    }
}

class RedirectedForm extends JPanel {

    public RedirectedForm() {

        JLabel label = new JLabel("You have been redirected to this Form becuse you have closed the previous one");
        add(label);
    }
}