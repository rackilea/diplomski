List<String> myAnswerList = new ArrayList<>(String);
myAnswerList.add(answer1);
myAnswerList.add(answer2);
myAnswerList.add(answer3);
myAnswerList.add(answer4);

// now mixed up
Collections.shuffle(myAnswerList);

tvQuestionAnswer1.setText(myAnswerList.get(0));
tvQuestionAnswer2.setText(myAnswerList.get(1));
tvQuestionAnswer3.setText(myAnswerList.get(2));
tvQuestionAnswer4.setText(myAnswerList.get(3));

// set the onClickListeners

//and in the onClick
@Override
public void onClick(View v) {
    checkAnswer(tvQuestionAnswer1.getText());
}