for (int i = 1; i <= 5; i++) {
  for(int rpts = 0; rpts < i; rpts++) {
    System.out.print('.');
  }
  for(int rpts = i; rpts < 5; rpts++) {
    System.out.print('*');
  }
  System.out.println();
}