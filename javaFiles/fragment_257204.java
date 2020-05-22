import java.util.Arrays;

public static void main(String[] args) throws java.lang.Exception {
    int oddNumber = 5;
    char character = '#';
    hourglass(oddNumber, character, 0);

} 

public static void hourglass(int oddNumber, char character, int currentLine) {
    if (currentLine == oddNumber) {
        return;
    }

    int patternLength = 0;

    int mid = (oddNumber + 1) / 2;

    if (currentLine < mid) {
        patternLength = oddNumber - (currentLine * 2);
    } else {
        patternLength = 2 * (currentLine - mid + 1) + 1;
    }

    char[] whitespace = new char[(oddNumber - patternLength)/2];
    Arrays.fill(whitespace, ' ');

    char[] pattern = new char[patternLength];
    Arrays.fill(pattern, character);
    System.out.println(new String(whitespace) + new String(pattern));

    hourglass(oddNumber, character, currentLine + 1);
}