List<Question> questions = questionDAO.list();
int size = questions.size();
JOptionPane.showMessageDialog(null, "There are " + size + " questions!");

for (Question question : questions) {
    jLabel5.setText(question.getText());
    jRadioButton1.setText("A. " + question.getOptionA());
    jRadioButton2.setText("B. " + question.getOptionB());
    jRadioButton3.setText("C. " + question.getOptionC());
    jRadioButton4.setText("D. " + question.getOptionD());
    // ...
}