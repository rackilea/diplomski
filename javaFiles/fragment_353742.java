public static void merge(File file1, File file2) throws IOException {

    Scanner scanner1 = new Scanner(file1);
    Scanner scanner2 = new Scanner(file2);

    while (scanner1.hasNextLine() && (scanner2.hasNextLine()){

        Strint line1 = scanner1.nextLine();
        String line2 = scanner2.nextLine();

        // parse line1
        String[] line1Tokens = lineS1,split(",");

        // parse line2
        String[] line2Tokens = line2.split(",");

        // Print
        String ticket = line1Tokens[0];
        String arrived1 = line1Tokens[2];
        String arraved2 = line1Tokens[3];

        String pickup1 = line2Tokens[1];
        String pickup2 = line2Tokens[2];

        System.out.println("Ticket: " + ticket + ", " + 
                           "Arrived: " + arrived1 + ":" + arived2 + " --- " + 
                           "Pickup: " + pickup1 + ":" + pickup2 + " --- " + 
                           "Cost: ");

    }
}

public static void main(String[] args){

    File file2 = new File("someText1.txt");
    File file1 = new File("someText1.txt");

    merge(file1, file2);

}