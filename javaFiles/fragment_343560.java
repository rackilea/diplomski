int current = start;
while (current++ <= end) { //assuming your ranges are inclusive
  if (current % quotient == 0) {
    publish(current);
  }
}