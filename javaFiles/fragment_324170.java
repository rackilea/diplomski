public void deduplicateFiles (String inputFileName, String outputFileName){
    Scanner scan = null;
    try {
        scan = new Scanner(new FileInputStream(inputFileName));
    } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
    }
    PrintWriter writer = null;
    try {
        writer = new PrintWriter(outputFileName);
    } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
    }
    while (true) {
        //this two lines are initial
        int firstInt = scan.nextInt();
        int counter = 1;

        //next lines are compare adjacent values
        while (scan.hasNextLine()) {
            int nextInt = scan.nextInt();
             if (nextInt == firstInt) {
                counter++;
            } else {
                System.out.println("counter " + counter);
                counter = 1;
                System.out.println(firstInt);
                 writer.println(firstInt);
                 firstInt = nextInt;
            }
        }

        //this three lines terminate adding
        writer.print(firstInt);
        System.out.println("counter " + counter);
        System.out.println(firstInt);

        break;

    }
    writer.flush();
    writer.close();
}