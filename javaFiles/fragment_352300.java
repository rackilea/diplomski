String h = getParameter("student1");
String i = getParameter("student2");
String j = getParameter("student3");

private void studentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {                                                   
    if (studentComboBox.getSelectedItem().equals("Student 1")){
        jlabel1.setText(h);
    } else if (studentComboBox.getSelectedItem().equals("Student 2")){
        jlabel1.setText(i);
    } else if (studentComboBox.getSelectedItem().equals("Student 3")){
        jlabel1.setText(j);
    }
}