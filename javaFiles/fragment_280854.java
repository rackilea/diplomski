public static void main(String[] args){
  // file names will be available as args[1] and args2[]
  String outputFileName = args[1];
  String errorOutputFileName = args[2];
  System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(args[1]))));
  System.setErr(new PrintStream(new BufferedOutputStream(new FileOutputStream(args[2]))));
  // ...

}