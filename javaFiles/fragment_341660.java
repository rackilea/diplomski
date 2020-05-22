Random r = new Random(); //you may want to declare this as a class field

List<Button> emptyButtons = new ArrayList<> ();

for (int i = 0; i < 3; i++) {
  for (int j = 0; j < 3; j++) {
    String s = buttons[i][j].getText().toString();
    if (s.isEmpty()) emptyButtons.add(buttons[i][j]);
  }
}

Button b = emptyButtons.get(r.nextInt(emptyButtons.size());
b.setText("O");
b.setTextColor(player));