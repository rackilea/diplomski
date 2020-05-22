List<Button> buttons = new ArrayList<Button>();
buttons.add((Button)findViewById(R.id.button0));
buttons.add((Button)findViewById(R.id.button1));
buttons.add((Button)findViewById(R.id.button2));
buttons.add((Button)findViewById(R.id.button3));
buttons.add((Button)findViewById(R.id.button4));

Collections.shuffle(buttons);

for (int i = 0, s = 4; i < s; i++) {
    buttons.get(i).setText("" + i);
}