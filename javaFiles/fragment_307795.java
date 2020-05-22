public class Main {

    JButton button;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main object = new Main();
                object.makeFrames();
            }
        });
    }

    public void makeFrames() {
        final CreateFrame frame = new CreateFrame("Label1");

        button = new JButton("Click");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.label.setText("new Label");
            }
        });
        frame.frame.add(BorderLayout.NORTH, button);
    }
}