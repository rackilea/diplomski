public static void test2( String[] array ) {
  int count = 0;
  for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 4; j++) {
      if (count < array.length) {
        System.out.print(array[count] + "\t"); 
        count++;
      }
    }   
    System.out.println();
    System.out.println();
    System.out.println();
  }
}