String dialogMessage = "Please suppliy digits to the following<br>input boxes:";
int btns = JOptionPane.OK_CANCEL_OPTION;
BorderLayout layout = new BorderLayout();
JPanel panel = new JPanel(layout);
JLabel label = new JLabel("<html>" + dialogMessage + "<br><br><br></html>");
panel.add(label, BorderLayout.NORTH);

JPanel p = new JPanel(new BorderLayout(5, 5));
JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
labels.add(new JLabel("Input A", SwingConstants.RIGHT));
labels.add(new JLabel("Input B", SwingConstants.RIGHT));
labels.add(new JLabel("Input C", SwingConstants.RIGHT));
labels.add(new JLabel("Input D", SwingConstants.RIGHT));
p.add(labels, BorderLayout.WEST);

JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
JTextField inputA = new JTextField();
controls.add(inputA);
JTextField inputB = new JTextField();
controls.add(inputB);
JTextField inputC = new JTextField();
controls.add(inputC);
JTextField inputD = new JTextField();
controls.add(inputD);
p.add(controls, BorderLayout.CENTER);
panel.add(p);

// Get Input from User...
int res = JOptionPane.showConfirmDialog(null, panel, "My Dialog Title", btns);
if (res == JOptionPane.OK_OPTION) {
    System.out.println("Input A is: " + inputA.getText());
    System.out.println("Input B is: " + inputB.getText());
    System.out.println("Input C is: " + inputC.getText());
    System.out.println("Input D is: " + inputD.getText());
}