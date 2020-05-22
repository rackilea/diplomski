public class WritePropertiesFile {
    public static void main(String[] args) {

        String customString = " are great!";

        try {
            Properties properties = new Properties();
            properties.setProperty("favoriteAnimal", "marmot" + customString);
            properties.setProperty("favoriteContinent", "Antarctica");
            properties.setProperty("favoritePerson", "Nicole");

            File file = new File("test2.properties");
            FileOutputStream fileOut = new FileOutputStream(file);
            properties.store(fileOut, "Favorite Things");
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}