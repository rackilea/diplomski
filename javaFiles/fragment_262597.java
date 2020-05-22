Numbersplode(int before, int goal) {
  this.before = before;
  this.goal = goal;
  processed = new int[before];
  transList();
}