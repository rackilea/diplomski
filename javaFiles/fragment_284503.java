public void actionPerformed(ActionEvent event) {

String clicked1 = event.getActionCommand();
String clicked2 = event.getActionCommand();

if (clicked1.equals("finalAmount")) {
prompt1 = new JLabel("Enter the initial amount:");
content.add(prompt1);

enterInitial = new JTextField(10);
content.add(enterInitial);

prompt2 = new JLabel("What's the constant?:");
content.add(prompt2);

enterConstant = new JTextField(10);
content.add(enterConstant);

prompt3 = new JLabel("How many years have elapsed?:");
content.add(prompt3);

enterElapsed = new JTextField(10);
content.add(enterElapsed);

calculate1 = new JButton("Calculate");
calculate1.setActionCommand("Calculate");
calculate1.addActionListener(this);
content.add(calculate1);

displayFinal = new JLabel(" ");
displayFinal.setForeground(Color.red);
content.add(displayFinal);

frame.pack();

//here should the if-loop end, because here is the end of instructions which should be called after clicking on the button
}
//and here the second if-loop
if (clicked2.equals("Calculate")){

    double finalAmount;
String e1 = enterInitial.getText();
String e2 = enterConstant.getText();
String e3 = enterElapsed.getText();

finalAmount = (Double.parseDouble(e1) + 2.0);

displayFinal.setText(Double.toString(finalAmount));
}