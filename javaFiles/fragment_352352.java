public class Frame extends JFrame {
    JButton testButton;

    public Frame() {
        testButton = new JButton();
        testButton.addActionListener(new listener());

        this.add(testButton);
    }
}