public Hangman(String fileName, int difficulty) {

    diff = difficulty;
    //easy = 0; medium = 1; hard = 2

    try (Scanner scanFile  = new Scanner(new File(fileName))) {

        while(scanFile.hasNext()) {

            String line = scanFile.nextLine();
            Scanner scanLine = new Scanner(line);
            String tempWord = scanLine.next();

            words.add(tempWord);
        }
    }
    catch (FileNotFoundException e) {
        System.out.println("File not found\n" + e);
    }
}