int tries = 8;
    // Writing to the file
    try {
        int content = tries;

        File file = new File("highscore.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        PrintWriter pw = new PrintWriter(new FileWriter(file, true));
        pw.println(content);
        pw.close();
        /*
         * FileWriter fw = new FileWriter(file.getAbsoluteFile());
         * BufferedWriter bw = new BufferedWriter(fw); bw.write(content);
         * bw.close();
         */
    } catch (IOException e) {
        e.printStackTrace();
    }
    /*
     * Writer wr; try { wr = new FileWriter("highscore.txt");
     * wr.write(tries); wr.close(); } catch (Exception e) {
     * 
     * }
     */

    // Getting the minimum score from the file
    int lowest = tries;
    File file = new File("highscore.txt");
    Scanner inputFile;
    try {
        inputFile = new Scanner(file);
        while (inputFile.hasNextInt()) {
            int numb = inputFile.nextInt();
            if (numb < lowest)
                lowest = numb;
        }
        System.out.println("lowest Score is: " + lowest);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }