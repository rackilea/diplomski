public class Lab8 extends JPanel
{
  private JPanel text;
  private JComboBox input;  // this guy remains null

  // .... etc ....

  public Lab8()
  {
    Integer [] select = {1,2,3,4};

    // the line below initializes a local input variable.
    // this variable is visible only inside of the constructor
    JComboBox input = new JComboBox(select); // ***** here ****