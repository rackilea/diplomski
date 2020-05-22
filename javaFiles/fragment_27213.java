public static void main(String[] args) throws IOException {
  if (args.length == 0) {
     // exit program with an error message
  } else {
     String textFile = args[0];
     Scanner scanner = new Scanner(new File(textFile));
     // do work with Scanner
  }