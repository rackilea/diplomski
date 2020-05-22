/**
 *
 * @param fileName is the path to the file or just the name if it is local
 * @return the number of lines in fileName
 */
public static int getLengthOfFile(String fileName) {
    int length = 0;
    try {
        File textFile = new File(fileName);
        Scanner sc = new Scanner(textFile);
        while (sc.hasNextLine()) {
            sc.nextLine();
            length++;
        }
    } catch (Exception e) {

    }
    return length;
}

/**
 *
 * @param fileName is the path to the file or just the name if it is local
 * @return an array of Strings where each string is one line from the file
 * fileName.
 */
public static String[] getWordsFromFile(String fileName) {
            int lengthOfFile = getLengthOfFile(fileName);
    String[] wordBank=new String[lengthOfFile];
    int i = 0;
    try {
        File textFile = new File(fileName);
        Scanner sc = new Scanner(textFile);
        for (i = 0; i < lengthOfFile; i++) {
        wordBank[i] = sc.nextLine();
        }
        return wordBank;
    } catch (Exception e) {
                System.err.println(e);
        System.exit(55);
    }
    return null;
}