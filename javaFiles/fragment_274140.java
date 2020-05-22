/**
 * findLineWithChar returns line in scanner if line has char c
 * 
 * @param scanner
 * 
 * @param c
 */
public static String findLineWithChar(Scanner scn, char c) {
    int counter = 0;
    while (scn.hasNextLine() && counter < 10) {
        String line = scn.nextLine();
        if (line.indexOf(c) > -1) {
            return line;
        }
        counter++;
    }
    return "";
}