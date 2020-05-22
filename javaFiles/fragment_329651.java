public static void main(String args[]) {
    readFile("C:\\sample.txt");
}

public static void readFile(String filename) {
    BufferedReader br = null;

    try {

        String sCurrentLine;

        br = new BufferedReader(new FileReader(filename));

        while ((sCurrentLine = br.readLine()) != null) {
            System.out.println(sCurrentLine);
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (br != null)br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}