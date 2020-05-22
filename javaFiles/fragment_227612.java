for(int i = 0; i < 7; i++) {
  int key = days.get((start + i) % 7);
  Button button = new Button(this);
  button.setText(map.get(key));
  dayLayout.addView(button);
}