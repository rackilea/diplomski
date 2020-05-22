public class Lab8 extends JPanel
{
  private JPanel text;
  private JComboBox input;

  // .... etc ....

  public Lab8()
  {
    Integer [] select = {1,2,3,4};
    // JComboBox input = new JComboBox(select); // ***** here ****
    input = new JComboBox(select); // ***** note difference? *****