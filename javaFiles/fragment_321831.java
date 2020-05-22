public static void runMe(int N) {
    int counter = 0;
    for(int x=0;x<N;x++){
      for(int y=x;y<N;y++){
        System.out.print("*");
      }
      System.out.println();
    }
}