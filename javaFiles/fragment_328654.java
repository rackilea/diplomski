Set<String> responses = new TreeSet<>();
.
.
newQuestionButton.addActionListener(ActionEvent evt)
{
    responses.add(userInputTextField.getText());
    userInputTextField.setText(""); //clear the field
}
.
.
.
finishedButton.addActionListener(ActionEvent evt)
{
    for(String question : responses)
    {
         add(new JLabel(question)); //or some variation, based on your layout.
    }
}