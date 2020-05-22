for (int i = 0; i < N; ++i) {
  for (int j = 0; j < i; ++j) {
     System.out.print(".");
  }

  for (int j = i; j < N; ++j) {
     System.out.print("*");
  }

  System.out.println(); // Next line
}