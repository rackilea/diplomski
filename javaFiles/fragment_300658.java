public class checkPanel extends JPanel implements ActionListener
{
private JPanel entry, display;
private JLabel name, checkAmount, payOrderOf, numPrint, numWords;
private JTextField nameT, checkAmountT;
private JButton Submit;

public checkPanel()
{
    this.setPreferredSize(new Dimension(750, 75));
    entryComponents();
    checkDisplay();

    this.setLayout(new BorderLayout());
    this.add(entry, BorderLayout.NORTH);
    this.add(display, BorderLayout.CENTER);
}
private void entryComponents(){

    entry = new JPanel();
    // You should specify entry's layout as well FlowLayout are used by default

    name = new JLabel("Name:");
    checkAmount = new JLabel("Check Amount:");


    nameT = new JTextField(20);
    nameT.addActionListener(this);

    checkAmountT = new JTextField(20);
    checkAmountT.addActionListener(this);

    Submit = new JButton("Submit");
    Submit.addActionListener(this);


    entry.add(name);
    entry.add(nameT);
    entry.add(checkAmount);
    entry.add(checkAmountT);
    entry.add(Submit);


    entry.setBackground(new Color(200,200,200));
}

private void checkDisplay(){

    display = new JPanel();
    // You should specify display's layout as well FlowLayout are used by       default

    payOrderOf = new JLabel("Pay to the Order of: ");


    display.add(payOrderOf);

    display.setBackground(new Color(220,255,225));
}
@Override
public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub

}

}