this.counter = 10;

...

case R.id.keypad_hash:
  checkAnswer();
  this.counter--;
  if( this.counter > 0 ){
    getQuestion();
  } else {
    scoreText.setText(score);
  }
  break;