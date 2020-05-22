int numberOfLineOfTheFile;  /* put the number of line of your file here */
String[][] tokens = new String[numberOfLineOfTheFile][];
String[] arrayOfTokens;

try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
    int i = 0;
    while ((line = br.readLine()) != null) {
       arrayOfTokens = line.split(" ");
       tokens[i++] = arrayOfTokens;
    }
}