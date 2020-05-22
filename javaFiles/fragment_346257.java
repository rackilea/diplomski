Collections.sort(inputArray, new Comparator < String > () {
 public int compare(String a, String b) {
  //if a = "80", b = "807"
  String ab = a + b; // 80807
  String ba = b + a; //80780
  // now compare
  return ab.compareTo(ba) > 0 ? -1 : 1;
 }
});