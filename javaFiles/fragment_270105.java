public class Main {

  public static void main(String[] args) {
    JFrame frame = new JFrame();

    int gridSize = 3; // try 4 or 5, etc. buttons are always 50x50

    JPanel panel = new JPanel(new GridLayout(gridSize, gridSize));
    panel.setPreferredSize(new Dimension(500, 500));

    for (int i = 0; i < gridSize; i++) {
      for (int j = 0; j < gridSize; j++) {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.CENTER;

        JButton button = new JButton();
        button.setPreferredSize(new Dimension(50, 50));
        buttonPanel.add(button, c);
        panel.add(buttonPanel);
      }
    }
    frame.setContentPane(panel);
    frame.pack();
    frame.setVisible(true);
  }
}