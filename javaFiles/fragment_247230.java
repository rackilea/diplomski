if (btnString1.equals(value)) {
    int text = Integer.parseInt(textField.getText());
    grades.add(text);
    textField.setText("");
    gradeCounter ++ ;
} else if (btnString2.equals(value)) {
    for (int i = 0; i < grades.size(); ++i) {
       sum += grades.get (i);
    }
    average = sum / gradeCounter;
    JOptionPane.showMessageDialog(this, average);

    exit();

}