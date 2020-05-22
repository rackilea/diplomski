import java.awt.*;
import javax.swing.*;

public class JFrameResize
{
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> createAndShowGUI());
  }

  public static void createAndShowGUI() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel inside = new JPanel()
    {
        @Override
        public Dimension getPreferredSize()
        {
            Dimension parent = getParent().getSize();
            Dimension child = new Dimension();

            int value = (parent.width * 3) - (parent.height * 4);

            if (value > 0)
            {
                child.height = parent.height;
                child.width = (int)(child.height * 4 / 3);
            }
            else
            {
                child.width = parent.width;
                child.height = (int)(child.width * 3 / 4);
            }

            return child;
        }
    };

    inside.setBackground(Color.BLUE);

    frame.setLayout( new GridBagLayout() );
    frame.add(inside, new GridBagConstraints());
    frame.pack();
    frame.setVisible(true);
  }
}