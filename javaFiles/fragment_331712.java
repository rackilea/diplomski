public boolean isOverlapping(List<Interval> sortedIntervals) {
  for (int i = 0, n = sortedIntervals.size(); i < n - 1; i++) {
    if (sortedIntervals.get(i).overlaps(sortedIntervals.get(i + 1))) {
      return true; // your evaluation for overlap case
    }
  }

  return false;
}