for (int i = 0; i < length - 1;) {
  j = text.indexOf(" ", i);

  if (i == j) { //if next space after space, skip it
    i = j + 1;
    continue;
  }

  if (j == -1) {
    j = text.length();
  }
  System.out.print("\n" + text.substring(i, j));
  i = j + 1;
}