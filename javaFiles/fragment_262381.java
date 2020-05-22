public static void main(String[] args) throws FileNotFoundException
{

    String phrase = ""; // a string of characters
    int countBlank; // the number of blanks (spaces) in the phrase 
    int length; // the length of the phrase
    char ch; // an individual character in the string
    int countA;
    int countE;
    int countS;
    int countT;

    java.io.File file = new java.io.File("sample.txt");
    Scanner inFile = new Scanner(file);

    while (inFile.hasNextLine())
        phrase += inFile.nextLine(); // Add line to 'phrase'
    length = phrase.length();

    // Initialize counts

    while (true) {

        countBlank = 0;
        countA = 0;
        countE = 0;
        countS = 0;
        countT = 0;

        for (int i = 0; i < length; i++) {
            ch = phrase.charAt(i);

            switch (ch)
            {
            case 'a':
            case 'A':
                countA++;
                break;
            case 'e':
            case 'E':
                countE++;
                break;
            case 's':
            case 'S':
                countS++;
                break;
            case 't':
            case 'T':
                countT++;
                break;
            case ' ':
                countBlank++;
                break;
            default:
                break;
            }

        }
        System.out.println();
        System.out.println("Number of blank spaces: " + countBlank);
        System.out.println();

        System.out.println("Number of A's: " + countA);
        System.out.println();
        System.out.println("Number of E's: " + countE);
        System.out.println();
        System.out.println("Number of S's: " + countS);
        System.out.println();
        System.out.println("Number of T's: " + countT);
        break;

    }

}