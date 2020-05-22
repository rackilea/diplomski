TextView step[] = new TextView[4];
step[0] = (TextView) findViewById(R.id.textview1);
step[1] = (TextView) findViewById(R.id.textview2);
step[2] = (TextView) findViewById(R.id.textview3);
step[3] = (TextView) findViewById(R.id.textview4);

Resources res = getResources();
String[] steps = res.getStringArray(R.array.dance_steps);

for(int i = 0 ; i < 4 ; i++){
    step[i].setText(steps[i]);
}