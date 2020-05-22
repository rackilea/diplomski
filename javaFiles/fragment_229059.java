public void paint(Graphics g) {
  int dataList[] = {2,4,6,9,5,4,5,7,12,15,21,32,45,5,6,7,12};
  int yposition = 100;

  g.drawString(("Sum of elements is: " + sum), 25, 25);
  g.drawString(("Product of elements is: " + product), 25, 50);
  g.drawString(("Number 5 is present " + fiveCounter + " times"), 25, 75);
  g.drawString(("The following numbers are multiple of 3"), 25, yposition);

  for (int i = 0; i < dataList.length; i++) {
    if ((dataList[i] % 3) == 0) {
      yposition += 15;
      g.drawString((String.valueOf(dataList[i])), 25, yposition);
    }
  }
}