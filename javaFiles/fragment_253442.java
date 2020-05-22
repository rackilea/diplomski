if (args.length == 0) {
  System.out.println("No file entered.");
  System.exit(1);
}

File inputFile = new File(args[0]);
System.out.println("Processing file");
try {
  SudokuReducer reducer = new SudokuReducer(inputFile);
  // Do something with reducer.
} catch (IOException e) {
  e.printStackTrace();
  System.out.println("File failed to open.");
  System.exit(1);
}