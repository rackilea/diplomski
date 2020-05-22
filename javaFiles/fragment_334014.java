public String readFile(String filename) {

    // variable representing a line of data in the mp3 file
    String line = "";

    try {
        br = new BufferedReader(new FileReader(new File(filename)));

        while (br.readLine() != null) {
          line+=br.readLine

        try {
            if (br == null) {

                // close reader when all data is read
                br.close();
            }

        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    } catch (FileNotFoundException e) {
        e.getMessage();
    } catch (IOException e) {
        e.printStackTrace();
    }
}