private int[] count = new int[4];
private int counter;

private void countUp() {
  counter++;
  count[0] = counter %10;
  count[1] = counter /10 % 10;
  count[2] = counter /100 % 10;
  count[3] = counter /1000 % 10;
}