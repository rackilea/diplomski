int[][] localArray;

public MyArray(int[][] initialArray) {
  localArray = initialArray.clone();
  for (int i = 0; i < initialArray.length; i++) {
     localArray[i] = initialArray[i].clone();
  }
}

public String toString() {
  // ...
}