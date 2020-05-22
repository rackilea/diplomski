public static void main(String[] args) { // This array is defined, but don't use it.
  test2(test());
}

public static String[] test() {
  return new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
}

public static void test2( String[] array ) {
  int count = 0;
  for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 4; j++) { 
      System.out.print(array[count] + "\t"); 
      count++;
    }   
    System.out.println();
    System.out.println();
    System.out.println();
  }
}