void copy(source, dest) {
  bool:containsAll = true;
  foreach(String s in source) {  // iteration 1
    if (not s in dest) {         // contains() test
       containsAll=false
       break
    }
  }
  if (not containsAll) {
    foreach(String s in source) { // iteration 2
      if (not s in dest) {        // contains() test
        add s to dest
      }
    }
  }
}