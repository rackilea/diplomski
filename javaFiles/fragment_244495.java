but = new Button[4][4];
linearLayout = (ViewGroup) findViewById(R.id.buttonlayout);
for (int r = 0; r<but.length; r++){
for (int c = 0; c<but.length; c++){
but[r][c] = new Button(this); // you should create your object before set layout!!
but[r][c].setLayoutParams(new LinearLayout.LayoutParams(20, 20));
but[r][c].setX(20 * r);
but[r][c].setY(20 * c);
but[r][c].setText(" ");
linearLayout.addView(but[r][c]);