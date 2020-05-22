new Ordering<X>() {
  public int compare(X x1, X x2) {
    return ComparisonChain.start()
      .compare(x1.stringValue, x2.stringValue)
      .compare(x2.dateValue, x1.dateValue) // flipped for reverse order
      .result();
  }
}.immutableSortedCopy(listOfXs);