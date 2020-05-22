public class PagePrinter {

    private final PrintStream printer;
    private final int pageWidth;
    private final int pageLength;

    private int currWidth = 0;
    private int currLine = 0;
    private int currPage = 1;

    private boolean inPageHeader = false;

    /**
     * @param printer
     *            - print stream to print to
     * @param pageWidth
     *            - in characters
     * @param pageLength
     *            - in lines, includes the length of the header
     */
    public PagePrinter(PrintStream printer, int pageWidth, int pageLength) {
        this.printer = printer;
        this.pageLength = pageLength;
        this.pageWidth = pageWidth;
    }

    public void print(String str) {
        // replace tabs with spaces
        // may need to replace other chars that don't translate to 1 char when printed
        str = str.replace("\t", "    ");
        // split would drop a trailing delimiter so concat extra
        String[] lines = str.concat("\r\n#").split("\\r?\\n");
        // print first
        printWords(lines[0]);
        // print rest excluding the extra
        for (int i = 1; i < lines.length - 1; i++) {
            // re-add delimiter (but keeping track of its affect on the page)
            newline();
            printWords(lines[i]);
        }
    }

    private void printWords(String str) {
        // split would drop a trailing delimiter so concat extra
        String[] words = str.concat(" #").split(" ");
        printWord(words[0]);
        for (int i = 1; i < words.length - 1; i++) {
            // re-add delimiter (but keeping track of its affect on the page)
            if (currWidth < pageWidth) {
                printer.print(" ");
                currWidth++;
            }
            printWord(words[i]);
        }
    }

    /** The smallest unit of appending to the document, */
    private void printWord(String word) {
        // determines when to print a header
        if (currLine == 0 && !inPageHeader) {
            printPageHeader();
        }

        int remainingSpaceOnLine = pageWidth - currWidth;
        if (word.length() < remainingSpaceOnLine) {
            printer.print(word);
            currWidth += word.length();
        } else if (word.length() < pageWidth) {
            newline();
            printWord(word);
        } else {
            // FIXME word is longer than the page width
            // maybe split it with a hyphen and addWord() the parts
            throw new RuntimeException("Word '" + word + "' is longer than line!");
        }
    }

    public void newline() {
        currLine++;
        if (currLine >= pageLength) {
            newPage();
        } else {
            currWidth = 0;
            printer.println();
        }
    }

    public void newPage() {
        if (inPageHeader) {
            throw new RuntimeException("Page header is longer than the page!!!");
        }
        currWidth = 0;
        currLine = 0;
        currPage++;
        printer.println();
    }

    private void printPageHeader() {
        inPageHeader = true;
        myPageHeader();
        inPageHeader = false;
    }

    protected void myPageHeader() {
        print("----- Page " + currPage + " -----\n");
    }


    public static void main(String[] args) {
        PagePrinter test = new PagePrinter(System.out, 40, 10);
        test.print("\tThis is the song that never ends. Yes, it goes on and on my friend. "
                + "Some people started singing it not knowing what it was "
                + "and they'll continue singing it forever just because..."
                + "\n\tThis is the song that never ends. Yes, it goes on and on my friend. "
                + "Some people started singing it not knowing what it was "
                + "and they'll continue singing it forever just because..."
                + "\n\tThis is the song that never ends. Yes, it goes on and on my friend. "
                + "Some people started singing it not knowing what it was "
                + "and they'll continue singing it forever just because.."
                + "\n\tThis is the song that never ends. Yes, it goes on and on my friend. "
                + "Some people started singing it not knowing what it was "
                + "and they'll continue singing it forever just because...");
        test.newPage();
        test.print("This is a new page!");
        test.newline();
        test.print("This is a newline even though part would've fit on the previous!");
    }
}