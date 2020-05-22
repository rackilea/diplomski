public class CreateFrame {
    JFrame frame;
    static JLabel label;
    // the rest of the class remains the same
}

public class Main {

    static JButton button;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CreateFrame frameFromMain = new CreateFrame("Label1");

                button = new JButton("Click");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CreateFrame.label.setText("new Label");
                    }
                });
                frameFromMain.frame.add(BorderLayout.NORTH, button);
            }
        });
    }
}