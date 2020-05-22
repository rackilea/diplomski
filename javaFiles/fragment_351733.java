public static void main(String[] args) {
      try {
         Scanner scanner = new Scanner(new File(FILE_POS));
         int count = 0;
         while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.printf("%3d: %s %n", count, line );
            count++;
         }