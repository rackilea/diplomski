public class TestFocusStuff extends JFrame implements ActionListener
{
  private final MyDialog mDialog = new MyDialog();

  public static void main(String[] args)
  {
    TestFocusStuff tfs = new TestFocusStuff();
    tfs.setVisible(true);
  }

  public TestFocusStuff()
  {
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    for (int i = 0; i < 10; i++)
    {
      JTextField tf = new JTextField(10);
      c.add(tf);
      tf.addActionListener(this);
    }
    pack();
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    mDialog.showQuickly();
  }

  private static class MyDialog extends JDialog
  {
    public void showQuickly()
    {
      setVisible(true);
      setVisible(false);
    }
  }
}