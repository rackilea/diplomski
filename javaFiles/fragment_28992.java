import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawLines {

  public static void main(String[] args) {

    List<Integer> xValues = new ArrayList<>();
    List<Integer> yValues = new ArrayList<>();

    JTextField fieldXbox = new JTextField();
    fieldXbox.addActionListener(e -> {
      System.out.println("Handled by Lambda listener");
      Integer coordinateX = Integer.parseInt(fieldXbox.getText());
      xValues.add(coordinateX);
      System.out.println("coordinateX" + coordinateX);
    });

    JTextField fieldYbox = new JTextField();
    fieldYbox.addActionListener(e -> {
      System.out.println("Handled by Lambda listener");
      Integer coordinateY = Integer.parseInt(fieldYbox.getText());
      yValues.add(coordinateY);
      System.out.println("coordinateY" + coordinateY);
    });

    Canvas canvas = new Canvas(xValues, yValues);
    canvas.setBorder(BorderFactory.createLineBorder(Color.black));

    JButton drawButton = new JButton("Draw");
    drawButton.addActionListener(e -> canvas.repaint());

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().setLayout(new GridBagLayout());
    f.getContentPane().add(fieldXbox, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
    f.getContentPane().add(fieldYbox, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
    f.getContentPane().add(drawButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    f.getContentPane().add(canvas, new GridBagConstraints(0, 1, 3, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
    f.setBounds(300, 200, 500, 400);
    f.setVisible(true);
  }
}

class Canvas extends JPanel {
  private List<Integer> xCoordinates;
  private List<Integer> yCoordinates;

  Canvas(List<Integer> xCoordinates, List<Integer> yCoordinates) {
    this.xCoordinates = xCoordinates;
    this.yCoordinates = yCoordinates;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (xCoordinates.size() != yCoordinates.size()) {
      throw new IllegalStateException("Difference in number of x coordinates and y coordinates." +
          " xCoordinates=" + xCoordinates + " yCoordinates=" + yCoordinates);
    }

    for (int i = 0; i < xCoordinates.size() - 1; i++) {
      g.drawLine(xCoordinates.get(i), yCoordinates.get(i), xCoordinates.get(i+1), yCoordinates.get(i+1));
    }
    if (!xCoordinates.isEmpty()) {
      g.drawLine(xCoordinates.get(xCoordinates.size() - 1), yCoordinates.get(yCoordinates.size() - 1),
          xCoordinates.get(0), yCoordinates.get(0));
    }
  }
}