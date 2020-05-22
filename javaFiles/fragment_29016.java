public class TestCalendar extends JFrame implements ActionListener {

  private JDateChooser dateChooser;

  public TestCalendar() {
    super("Simple");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    dateChooser = new JDateChooser();
    add(dateChooser);
    JButton button = new JButton("Check");
    button.addActionListener(this);
    add(button);
    setSize(300, 100);
  }

  public void actionPerformed(ActionEvent e) {
    Date date = dateChooser.getDate();
    if (date == null) {
      JOptionPane.showMessageDialog(TestCalendar.this, "Date is required.");
    }
  }

  public static void main(String[] args) {
    new TestCalendar().setVisible(true);
  }

}