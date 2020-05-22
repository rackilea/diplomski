public int getScore() {
  int answer;
  String ans = ((EditText)findViewById(R.id.answerField)).getText().toString();

    try {

      return Integer.valueOf(ans);
    } catch (NumberFormatException e) {
        //value in answerField is not Integer do whatever you need
      //return -1, just to make it complete, you should change it
      return -1;
    }