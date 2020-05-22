public class Constants {
    private static Constants instance;

    private int width;
    private int height;

    private Constants() {
        //initialize data,set some parameters...
    }

    public static Constants getInstance() {
        if (instance == null) {
            instance = new Constants();
        }
        return instance;
    }

    //getters and setters for widht and height...
}