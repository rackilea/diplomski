View player1 =  findViewById(R.id.player1);
View player2 =  findViewById(R.id.player2);
button.setOnTouchListener(new RepeatListener(400, 100, new OnClickListener() {
@Override
public void onClick(View view) {
  // the code to execute repeatedly
  player1.setX(player1.getX() - 30);
  player2.setX(player2.getX() + 30);
}
}));