public class Test {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("Focus JTextField");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                MyPanel myPanel = new MyPanel();
                frame.add(myPanel);
                frame.setVisible(true);
                frame.pack();
                myPanel.focusTextField();
            }
        });
    }
}

class MyPanel extends JPanel {
    private JTextField textField;

    public MyPanel() {
        textField = new JTextField(20);
        add(textField);
    }

    public void focusTextField() {
        textField.requestFocusInWindow();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 100);
    }
}