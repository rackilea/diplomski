public static void main(String[] args) {
  if (args.length < 1) {
     throw new Exception("Specify a filename!");
  }
  File inputDataFile = new File(args[0]);
  ..