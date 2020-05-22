public class MyPanel extends JPanel {

    private Color color = Color.red;
    // this color should be used within paintComponent() method

    public void setColor(Color newColor) {
        color = newColor;
        repaint();
    }

    ...
}