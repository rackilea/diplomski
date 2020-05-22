public class ResultPane extends JPanel {

private JLabel result;
private Timer timer;

private int xDelta = (Math.random() > 0.5) ? 1 : -1;
private int yDelta = (Math.random() > 0.5) ? 1 : -1;

public ResultPane() {
    setOpaque(false);
    setLayout(null);
    result = new JLabel();
    Font font = result.getFont();
    font = font.deriveFont(Font.BOLD, 26f);
    result.setFont(font);
    add(result);
    timer = new Timer(40, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Point point = result.getLocation();
            point.x += xDelta;
            point.y += yDelta;
            if (point.x < 0) {
                point.x = 0;
                xDelta *= -1;
            } else if (point.x + result.getWidth() > getWidth()) {
                point.x = getWidth() - result.getWidth();
                xDelta *= -1;
            }
            if (point.y < 0) {
                point.y = 0;
                yDelta *= -1;
            } else if (point.y + result.getHeight() > getHeight()) {
                point.y = getHeight() - result.getHeight();
                yDelta *= -1;
            }
            result.setLocation(point);
            repaint();
        }

    });
    timer.start();
}

public void setResult(Number number) {
    result.setText("Result: " + NumberFormat.getNumberInstance().format(number));
    result.setSize(result.getPreferredSize());
    setVisible(true);
}

public String getResultText(){
    return result.getText();
}

}