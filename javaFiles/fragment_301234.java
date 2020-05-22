s.quickSort(enten, 0, enten.length -1);

// Print missing numbers less than the smallest element.
for (int j = 0; j < enten[0]; ++j) {
  System.out.println(j);
}

// Print missing numbers between elements.
for (int i = 1; i < enten.length; ++i) {
  // If enten[i - 1] + 1 >= enten[i], this loop body never runs.
  for (int j = enten[i - 1] + 1; j < enten[i]; ++j) {
    System.out.println(j);
  }
}

// Print missing numbers greater than the largest element.
for (int j = enten[enten.length-1] + 1; j <= 9; ++j) {
  System.out.println(j);
}