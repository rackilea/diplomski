DisplayMeasurement screenValue = new DisplayMeasurement(this);
int WidthScreen = screenValue.getWidthScreen();
int HeightScreen = screenValue.getHeightScreen();


TextView text1 = (TextView) findViewById(R.id.text1);
TextView text2 = (TextView) findViewById(R.id.text2);

text1.setText("lebar" + WidthScreen);
text2.setText("tinggi" + HeightScreen);