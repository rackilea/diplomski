class Complex {
  public String a = "";
  public String b = "";
}

//...

Collections.sort(someList, new Comparator<Complex>() {
  public int compare(Complex e1, Complex e2) {
    if (e1 == e2) {
      // Refs could be null or equal
      return 0;
    }
    if (e1 == null && e2 != null) {
      return -1;
    }
    if (e2 == null && e1 != null) {
      return 1;
    }
    if (e1.a == e2.a) {
      return 0;
    }
    if (e1.a == null && e2.a != null) {
      return -1;
    }
    if (e1.a != null && e2.a == null) {
      return 1;
    }
    // Just use the Comparable on the fields
    return e1.a.compareTo(e2.a);
  }
});