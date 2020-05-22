static void loadPatientData()  {
    Scanner fileRead = new Scanner("John Doe;true;true;0\r\nJane Roe;false;true;2\r\n");
    fileRead.useDelimiter(";|\r\n"); // vs.:
//  fileRead.useDelimiter(";|\n");

    while (fileRead.hasNext()) {
        String name = fileRead.next();
        boolean bob = fileRead.nextBoolean();
        boolean joe = fileRead.nextBoolean();
        int queue = fileRead.nextInt(); //hell breaks loose
    }
}