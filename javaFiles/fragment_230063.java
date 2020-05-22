try
{
    grade = Integer.parseInt(inputGrade.getText());
    if (grade >= 9 && grade <= 12) {
        // Valid
        outputHint.setText("Grade valid");
    } else {
        // Not valid
        outputHint.setText("Grade not valid");
    }
}
catch(NumberFormatException e)
{
    outputHint.setText("Grade not valid");
}