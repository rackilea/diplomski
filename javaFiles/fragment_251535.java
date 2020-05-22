public static void main(String[] args) {
    Scanner input = new Scanner(System.in).useLocale(Locale.US);

    int lines = 0;
    int words = 0;

    String currLine = "?"; 
    while (currLine != null && currLine.trim().length() > 0) {
        currLine = input.nextLine();
        words = words + currLine.split("\\W+").length;
        lines++;
    }

    System.out.printf("%30s\n", "The text has " + (lines - 1) + " lines");
    System.out.printf("%30s\n", "The text has " + (words - 1) + " words");
    input.close();    
}