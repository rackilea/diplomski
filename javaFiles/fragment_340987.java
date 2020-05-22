public void typeKey(View sender)
{
        Button pressed = (Button) sender;
        answer.add(ansLength, (String) pressed.getText());
        ansLength++;
        answerbox.setText((CharSequence) answer);
}