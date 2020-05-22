class Database {

    private static Database theInstance;

    private Database() {
        // Create connections here and stuff
    }

    public static Database getInstance() {
        if (theInstance == null) {
            theInstance = new Database();
        }
        return theInstance;
    }

}