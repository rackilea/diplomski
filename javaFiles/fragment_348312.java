@Test
public void test() {

    BufferedReader br = null;

    try {

        String sCurrentLine;
        StringBuffer fileContent = new StringBuffer();
        int consecutiveEmptyLineCounter = 0;

        br = new BufferedReader(new FileReader("D:\\partha\\check.txt"));

        while ((sCurrentLine = br.readLine()) != null) {

            // if this is not an empty line
            if (!(sCurrentLine.trim().length() == 0)) {

                // if there are no empty lines before this line.
                if (!(consecutiveEmptyLineCounter > 0)) {

                    // It is a non empty line, with non empty line prior to this
                    // Or it is the first line of the file.
                    // Don't do anything special with it.
                    // Appending "|" at the end just for ease of debug.
                    System.out.println(sCurrentLine + "|");
                } else {

                    // This is a non empty line, but there were empty lines before this.
                    // The consecutiveEmptyLineCounter is > 0
                    // The "fileContent" already has the previous empty lines.
                    // Add this non empty line to "fileContent" and spit it out.

                    fileContent.append(sCurrentLine);
                    System.out.println(fileContent.toString() + "@");

                    // and by the way, the counter of consecutive empty lines has to be reset.
                    // "fileContent" has to start from a clean slate.
                    consecutiveEmptyLineCounter = 0;
                    fileContent = new StringBuffer();
                }
            } else {
                // this is an empty line

                // Don't execute anything on it.
                // Just keep it in temporary "fileContent"
                // And count up the consecutiveEmptyLineCounter
                fileContent.append(sCurrentLine);
                fileContent.append(System.getProperty("line.separator"));
                consecutiveEmptyLineCounter++;

            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (br != null)
                br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}