private Color[] colorArray = new Color[24];
private int currentIndex = 0;

public void addColorToArray(int red, int green, int blue) {
  colorArray[currentIndex++] = new Color(red, green, blue);
}

public void myMethodThatDoThis24Times() {
   addColorToArray(getRedAverage(), getGreenAverage(), getBlueAverage());
   addColorToArray(getRedAverage(), getGreenAverage(), getBlueAverage());
   ...
}