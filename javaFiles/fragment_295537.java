// The name of the file which we will read from
        String filename = "TotalValue.txt";

        // Prepare to read from the file, using a Scanner object
        File file = new File(filename);
        Scanner in = new Scanner(file);

        int value = 0;

        while(in.hasNextLine()){
             in.next();
             value = in.nextInt();
             //Do something with the value here, maybe store it into an ArrayList.
        }