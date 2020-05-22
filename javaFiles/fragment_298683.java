static Stats getStatsFromVals(List<Double> vals) {
  double min = Double.POSITIVE_INFINITY;
  double max = Double.NEGATIVE_INFINITY;
  double avg = 0.0;
  for(double val : vals) {
    avg += val;
    if(val < min)
      min = val;
    if(val > max)
      max = val;
  }
  avg /= vals.size();
  return new Stats(min, max, avg);
}