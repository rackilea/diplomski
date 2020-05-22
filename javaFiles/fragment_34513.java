public static void main(final String[] args) {
if (args.length == 0) {
    System.out.println("Please provide a correct directory path as an argument!");

} else {

    System.out.println("Thanks for using our CodeMetrics\n"
            + "The process Might take a long time, please wait!\n"
            + "Please check the CSV file for the final results!");
    File ad = new File(args[0]);
    File[] list = ad.listFiles();

   //ask the user here
   Scanner sc = new Scanner(System.in);

   System.out.println("Please enter a number : Would you like to (1) print, or (2) print & write?");
   int answer = scan.nextInt();
   boolean write = false;
   if (answer == 2) {
      write = true;
   }

    for (File f : list) {

        CodeMetrics codeMetrics = new CodeMetrics();

        codeMetrics.parseCommandLine(f.toString());
        codeMetrics.countComplexity(codeMetrics.sourceCodeFile);

        // Count LOC (Lines of Code)
        codeMetrics.countLines(codeMetrics.sourceCodeFile);
        codeMetrics.countTestLines(codeMetrics.testFiles);

        //check whether the user wants to write or not
        if (write == false) {
            codeMetrics.printReport();
        } else {
            codeMetrics.printReport();
            codeMetrics.writeReport();
        }
    }

}