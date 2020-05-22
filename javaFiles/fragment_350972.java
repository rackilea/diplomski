double[] marks = new double[6];
int numbers = 1;
int count = 0;
// This is for asking input
for (int i = 0; i < marks.length; i++,numbers++) {
  String marksString = JOptionPane.showInputDialog (null,
      "Enter the marks for student "+numbers+": ");
  marks[i] = Double.parseDouble(marksString);
  if(marks[i] >= 80.0) {
    count++;
  }
}
System.out.println("The number of students who got A is " + count);