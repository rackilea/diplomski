public class TestResults {

   public static void main(String[] args) {
    Scanner namesFile;
    PrintWriter passFile;
    PrintWriter failFile;


     String errs = "";
    Scanner k = new Scanner(System.in);

    try {
        try {
                namesFile = new Scanner(new File("D:/Names.txt"));

                passFile = new PrintWriter("D:/Pass.txt");
                failFile = new PrintWriter("D:/Fail.txt");



                try {
                    while (namesFile.hasNext()) {
                    String tempLine = namesFile.nextLine();
                    System.out.println("Please Enter Mark For " + tempLine + " : ");
                    int mark = k.nextInt();
                    if (mark >= 40) {
                        passFile.println(tempLine + " " + mark + "%");
                    } else {
                        failFile.println(tempLine + " " + mark);
                    }
                    }
                } catch (InputMismatchException ime) {
                    String valueStr = namesFile.next();
                    errs += "\n\t" + valueStr;
                } finally {
                    namesFile.close();
                    passFile.close();
                    failFile.close();
                }



        }
        catch(IOException ioe){
            System.out.println("ERROR: " + ioe.getMessage());
        }



    } // Checks to see if file is there.
    catch (Exception e) {

    }

  }
}