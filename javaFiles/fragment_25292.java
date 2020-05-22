public class MyApp extends Application {
    private static Exhibit sExhibit;

    public static void setExhibit(Exhibit exhibit) {
        sExhibit = exhibit;
    }

    public static Exhibit getExhibit() {
        return sHexhibit;
    }
}

// To set the object:
MyApp.setExhibit(myExhibit);

// To retrieve it
Exhibit myExhibit = MyApp.getExhibit()