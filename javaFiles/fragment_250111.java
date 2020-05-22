public void nextQuestion(int index){

index++;
txtQuestion.setText(questionList.get(index));
btnFirst.setText(choiceList.get(index * 4));
btnSecond.setText(choiceList.get(index * 4 + 1));
btnThird.setText(choiceList.get(index * 4 + 2));
btnFourth.setText(choiceList.get(index * 4 + 3));

}