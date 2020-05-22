...
int Value1, Value2, Value3, average;

Value1 = Integer.parseInt(JOptionPane.showInputDialog("What is your first value?"));

Value2 = Integer.parseInt(JOptionPane.showInputDialog("What is your second value?"));

Value3 = Integer.parseInt(JOptionPane.showInputDialog("What is your third value?"));

average = (Value1 + Value2 + Value3) / 3;

JOptionPane.showMessageDialog(null, "The average grade is " + average + "%.");
...