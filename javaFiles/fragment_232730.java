public class MyButton extends JButton {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isSelected()) {
            setBorder(BorderFactory.createEmptyBorder());
        } else {
            setBorder(BorderFactory.createLoweredBevelBorder());
        }
    }
}