private static void changeColors( ) {
  for (int i=0;i<buttons.length;i++){
    buttons[i].setBackground(COLORS[currentColor]);
    currentColor = nextColor(currentColor);
  }
  if (buttons.length == COLORS.length) {
    currentColor = nextColor(currentColor);
  }
}

private static int nextColor(int currentColor) {
  return (currentColor+1)% COLORS.length;
}