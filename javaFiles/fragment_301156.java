public class CursorTest extends JFrame
{
  private CursorTest()
  {
  }

  private void ShowDialog()
  {
        JLabel label = new JLabel("Move mouse here for hand cursor");
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JOptionPane pane = new JOptionPane(label);
        pane.setOptions(new Object[] { "OK" } );

        JDialog dialog = pane.createDialog(this, "Test Dialog");
        dialog.setVisible(true);
  }

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        CursorTest testFrame = new CursorTest();
        testFrame.setTitle("Test GUI");
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.setSize(500, 300);
        testFrame.setVisible(true);
        testFrame.ShowDialog();
      }
    });
  }
}