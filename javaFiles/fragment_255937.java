public class MyApp extends Application {
    // implement ...
}

public class Main {
    public static void main(String[] args) {
        // Perform pre-checks, return if necessary
        Application.launch(MyApp.class, args);
    }
}