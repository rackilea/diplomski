for(int i = l-1; i > -1; i--) {
     int padding = s.length() - i;
     if(padding > 0)
     {
          System.out.printf("%" + padding + "s", " ");

         //for inner loop
      }
      for(int j = 0; j < i; j++)  {
            System.out.printf("%c ", s.charAt(j));
      }
      System.out.printf("%c\n", s.charAt(i));
}