public static void main(String[] args) throws IOException {
String words, message;
int numberWords = 0, countNumber = 0;
FileInputStream fis = new FileInputStream("src/WordsandNumbers.txt");
Scanner in = new Scanner(fis);

String numRegex   = ".*[0-9].*";
String alphaRegex = ".*[A-Za-z].*";

while (in.hasNext()) {
    words=in.next();
    if (words.matches(alphaRegex)) {
        numberWords++;
    }
    else if(words.matches(numRegex))
    {
        countNumber++;
    }        
}

in.close();

message = "The number of words read from the file was " + numberWords
        + "\nThe count of numbers read from the file was" + countNumber;

System.console().writer().println(message);