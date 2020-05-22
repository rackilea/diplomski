public static void main(String[] args) throws FileNotFoundException {

    Scanner gpadata = new Scanner(new File("studentdata.txt"));
    List<String> IDs = new ArrayList<>();
    List<Double> GPAs = new ArrayList<>();
    while (gpadata.hasNext()) // loop until you reach the end of the file
    {
        String snum = gpadata.next(); // reads the student's id number
        double gpa = gpadata.nextDouble(); // read the student's gpa

        IDs.add(snum);
        GPAs.add(gpa);

        System.out.println(snum + "\t" + gpa); // display the line from the file in the Output window
    }
    // Use IDs and GPAs Lists for other calculations
}