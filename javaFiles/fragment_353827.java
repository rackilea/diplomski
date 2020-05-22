public static void main (String[] args) {
   String pathname;
   if (args.length > 1) {
       System.err.println("Error: Too many command line parameters.");
       System.exit(1);
   } else if (args.length > 0) {
       pathname = args[0]; // from the command line
   } else {
       // get pathname from somewhere else, e.g. read from System.in
   }
}