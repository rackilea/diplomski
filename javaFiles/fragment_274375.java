public static void main(String[] args) {
    int wordList[] = new int[20];
    System.out.println("Please enter a sentence.");
    Scanner scanner = new Scanner(System.in); //Use a scanner, part of the standard JDK

    for (int i = 0; i <= wordList.length; i++) {
        String s = scanner.next(); //reads the next string
        int length = s.length();
        wordList[length]++;
    }

    for (int i = 0; i < wordList.length; i++) { //use a for loop
        if (wordList[i] > 0) {
            System.out.println(i + "-letter words: " + wordList[i]);
        }
    }
}