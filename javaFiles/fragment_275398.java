public final class WriteFile {

    private WriteFile(){/* This is a class with only static methods - make the constructor private to prohibit instantiation */}

    public static final String heading = "UserID, First Name, Last Name, Age, Ethnic, Gender, Score Game 1, Score Game 2";

    private static BufferedWriter bufferedFileWriter = null;

    static {
        File file = new File("ResultsSaves.txt");

        // if file exists, then overwrite current saved file with new
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        bufferedFileWriter = new BufferedWriter(fw);
    }

    private static String getGameResult() {
        return Globals.IDUser + ", " + Globals.firstName + ", " + Globals.lastName + ", " + Globals.userAge + ", " + Globals.eThnic + ", " + Globals.maleOrFem  + ", " + " In the first game you scored, " + Globals.score + ", " + " In the second game you scored." + Globals.score2; 
    }

    /** Not really needed, but there to stay true to the original design */
    public static void printHeading() throws IOException {
        save(heading); 
    }

    /** Not really needed, but there to stay true to the original design */
    public static void saveGame() throws IOException {
        save(getGameResult()); 
    }

    public static void save(String content) throws IOException {

        bufferedFileWriter.write(content);
        bufferedFileWriter.newLine();
        // flush to get the contents stored to file
        bufferedFileWriter.flush();  

        JOptionPane.showMessageDialog(null, "Your details have been saved!");   

        }
    }

    /** Don't close the writer before all desired content is written. */
    public static void close() throws IOException {
        bufferedFileWriter.close(); 
    }
}