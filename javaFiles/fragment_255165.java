public static void main(String[] args) throws FileNotFoundException {

    Scanner gpadata = new Scanner(new File("studentdata.txt"));
    String[] IDs = new String[1000];
    double[] GPAs = new double[1000];
    int counter = 0;

    while (gpadata.hasNext()) // loop until you reach the end of the file
    {
        String snum = gpadata.next(); // reads the student's id number
        double gpa = gpadata.nextDouble(); // read the student's gpa

        IDs[counter] = snum;
        GPAs[counter] = gpa;

        System.out.println(snum + "\t" + gpa); // display the line from the file in the Output window
        counter++;
    }
    // Use IDs and GPAs Lists for other calculations
}