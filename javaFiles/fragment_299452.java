private long threshold; //mutable, may change

boolean moreThanThreshold(long value) {
  return value > threshold; //side comment: cleaner than your if/else
}
void setThreshold(long t) { this.threshold = t; }