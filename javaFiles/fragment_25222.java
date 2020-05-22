// this is the id of the button that is correct, where x represents its index, which you know ahead of time
int id = answerButtons[x].getId();

for (int i = 0; i < 4; i++) {
     answerButtons[i].setOnClickListener(new YourListener(id));
}