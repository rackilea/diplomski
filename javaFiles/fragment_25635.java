import javax.swing.*;
import java.awt.event.*;

public class ScrollPaneEvents
{
  private static final float THRESHOLD = 0.9f;

  public static void main(String[] args)
  {
    JTextArea textArea = new JTextArea("A\nB\nC\nD\nE\nF\nG\nH\nI\nJ\nK\nL\nM\nN\nO\nP\nQ\nR\nS\nT\nU\nV\nW\nX\nY\nZ\n");
    JScrollPane scrollPane = new JScrollPane(textArea);

    scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener()
    {
      @Override
      public void adjustmentValueChanged(AdjustmentEvent e)
      {
        int maxValue = scrollPane.getVerticalScrollBar().getMaximum() - scrollPane.getVerticalScrollBar().getVisibleAmount();
        int currentValue = scrollPane.getVerticalScrollBar().getValue();
        float fraction = (float) currentValue / (float) maxValue;

        if (fraction > THRESHOLD)
        {
          System.out.println("Scroll bar is near the bottom");
        }
      }
    });

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(scrollPane);
    frame.setBounds(300, 200, 400, 300);
    frame.setVisible(true);
  }
}