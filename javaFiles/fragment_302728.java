public static void displayPatternIII (int lines) {

    for (int i = 1; i <= lines; i++){
      System.out.print(" ");
        for (int j = lines; j > 0; j--)
            System.out.print (j > i ? " " : j);
        System.out.println();
    }
}