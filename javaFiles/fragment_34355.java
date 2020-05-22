for (String str : values) {
  char[] c = str.toCharArray();
  int x = Character.getNumericValue(c[0]);
  int y = Character.getNumericValue(c[1]);
  int z = Character.getNumericValue(c[2]);
  grille[x][y] = z;
}