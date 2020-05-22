public void typeKey(View sender)
{
    Button pressed = (Button) sender;
    answer.add(ansLength, (String) pressed.getText());
    ansLength++;


    StringBuilder stringBuilder = new StringBuilder();
    for (String string : answer) {
        stringBuilder.append(string);
    }

    answerbox.setText(stringBuilder.toString());
}