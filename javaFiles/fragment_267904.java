public static void main(String[] args) {
    String inputFile = "c:/input.csv";
    String outputFile = "c:/output.csv";
    int lineNumber = 0;                    // <-- keep a line count.
    Scanner scanner = null;
    PrintWriter pw = null;
    try {
        pw = new PrintWriter(outputFile);  // <-- output
        File source = new File(inputFile);
        scanner = new Scanner(source);     // <-- input
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = (line != null) ? line.trim() : "";
            if (line.length() < 1) {
                continue;
            }
            // line 0 is the header.
            if (lineNumber != 0) {
                pw.print(lineNumber);
                pw.print(", ");
            }
            int tokenCount = 0;
            StringTokenizer st = new StringTokenizer(line, ",");
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (tokenCount != 0) {
                    pw.print(", ");
                }
                pw.print(token.trim());
                tokenCount++;
            }
            pw.println();
            lineNumber++;
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } finally {
        if (scanner != null) {
            scanner.close();
        }
        if (pw != null) {
            pw.close();
        }
    }
}