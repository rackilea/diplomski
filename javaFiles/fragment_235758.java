public static void main(String[] args) throws IOException {
  FileInputStream inputStream = null;
  Scanner sc = null;
  try {
     PrintStream out = new PrintStream(new FileOutputStream("output.csv"));
     System.setOut(out);
  }
  catch(IOException e1) {
    System.out.println("Error during reading/writing");
  }
  try {
      inputStream = new FileInputStream("my-large-file.txt");
      sc = new Scanner(inputStream, "UTF-8");
      while (sc.hasNextLine()) {
        String line = sc.nextLine();

        // note the specific indecies of the substring are random nums, and does not affect the program. They could be anything.
        if (!line.startsWith("the-number-that-I-don't-want"))) {
           String filter2 = line.substring(55, 66);         
           if (!(filter2.equals("another-string-to-filter-out"))) {
              StringBuffer current     = new StringBuffer(line.substring(1, 10));
              StringBuffer another     = new StringBuffer(line.substring(10, 20).replaceAll("\\s+",""));
              StringBuffer third       = new StringBuffer(line.substring(22, 37).replaceAll("\\s +",""));
              StringBuffer fourth      = new StringBuffer(line.substring(37, 56));

              ...
              StringBuffer nth         = new StringBuffer(line.substring(999, 1000));

              System.out.println(currentS + ", " + firstName + ", " + lastName + ", " + birthday + ", " + distributedAmt + ", " +awardYear + ", " + transactionNum + ", " + disbursementDate + ", " + efc + ", " + percentEligUsed + ", " + grantType);
           }
        }
     }

     if (sc.ioException() != null) {
        throw sc.ioException();
     }
  } finally {
     if (inputStream != null) {
        inputStream.close();
     }
     if (sc != null) {
        sc.close();
     }

  }                                                                              
}