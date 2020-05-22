public static void main(String args[]) {
  for(int i = 0; i < 9; i++) {
    for (int j = 0; j < 9; j++) {
      if ((i + j) > 3 && (i + j) < 13) {
        System.out.println(i + ", " + j);
      }
    }
  }
}