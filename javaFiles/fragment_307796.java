public class Main {

    static JButton button;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final CreateFrame frameFromMain = new CreateFrame("Label1");

                button = new JButton("Click");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frameFromMain.label.setText("new Label");
                    }
                });
                frameFromMain.frame.add(BorderLayout.NORTH, button);
            }
        });
    }
}