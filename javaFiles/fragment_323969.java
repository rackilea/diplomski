double mean(double[] ary) {
  double avg = 0;
  int t = 1;
  for (double x : ary) {
    avg += (x - avg) / t;
    ++t;
  }
  return avg;
}