public static void readingFiles() throws Exception {
    BufferedReader reader = null;
    String filename = null;
    Scanner input = new Scanner(System.in);
    boolean fileFound = true;
    do {
        System.out.print("Enter a file name or Type END to exit: ");
         if(input.hasNextLine()) {
             filename = input.nextLine();
                try {
                    File f = new File(filename);
                    // reader =
           ... 
    } while (!filename.equalsIgnoreCase("end");