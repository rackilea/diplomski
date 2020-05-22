private final String REGEX = "([1-9]|[1-4]\\d|50)\\t([1-4]\\d\\d|500)";

public void testFile(String fileName) {
    int lineCounter = 1;
    try {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine();
        while ((line != null) && (lineCounter <= MAX_LINES_TO_READ)) {
            if (line.matches(REGEX)) {
                System.out.println("Line " + lineCounter + " formatted correctly");
            } else {
                System.out.println("Invalid format on line " + lineCounter + " (" + line + ")");
            }
            line = br.readLine();
            lineCounter++;
        }
        br.close();
    } catch (Exception ex) {
        System.out.println("Exception occurred: " + ex.toString());
    }
}