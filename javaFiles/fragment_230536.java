while(inFile.hasNextLine()){
    String line = inFile.nextLine();
    for (String word : line.split(" ")) {
        wordCount++;
        int wordLength = word.length();
        if (wordLength == 3){
            threeLetters++;
        }
    }
}