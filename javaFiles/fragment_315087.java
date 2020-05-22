public class ZipReader {

public static void main(String[] args) {

    //Gets the file name and reads it
    try {
        //Prompts user for an input file
        Scanner console = new Scanner(System.in);
        System.out.println("Input file: ");
        String inputFileName = "G:\\test.txt";

    //Prompts user for an output file
        //System.out.println("Output file: ");
        //String outputFileName = console.next();
        //PrintWriter out = new PrintWriter(outputFileName);
        //Reads the selected file line for line
        File selectedFile = new File(inputFileName);
        Scanner in = new Scanner(selectedFile);
        String states="";
        while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner in2 = new Scanner(line);

            //Reads the selected file word for word
            while (in2.hasNext()) {
                //String state = in2.isLetter();
                String word = in2.next();
                if (word.matches("\\d{3}-\\d{3}")) {
                    System.out.println(word);
                }
                else if (word.matches("\\d{3}")) {
                    System.out.println(word + "-" + word);
                }
                else if(word.matches("[A-Z]{2}")){
                    System.out.println(word);
                }

                else{
                    states=states+word+" ";
                }
            }
            System.out.println(states+"\n");
            states="";
            in2.close();//closes the word scanner
        }
        console.close();//closes the file opener scanner
        in.close();//closes the line scanner
        //out.close();//closes the print writer
    } //Prints out message if file cant be found
    catch (FileNotFoundException e) {
        System.out.println("Sorry the file could not be found.");
    } //Needed to compile
    finally {
    }
  }
}