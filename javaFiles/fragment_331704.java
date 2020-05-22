Scanner fileScanner = new Scanner(new File("C:\\MyJavaFolder\\JavaAssignment1\\TestFile.txt"));
    int totalWordCount = 0;
    ArrayList<String> words = new ArrayList<String>();

    //Firstly to count all the words in the file without the restricted characters 
    while (fileScanner.hasNext()) {
        //Add words to an array list so you only have to go through the scanner once
        words.add(fileScanner.next());//This defaults to whitespace
        totalWordCount++;
    }
    System.out.println("There are " + totalWordCount + " word(s)");
    fileScanner.close();