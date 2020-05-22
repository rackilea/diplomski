public class MyApp extends Application {

    private static List<String> data = new ArrayList<>();

    public static void addItem(String item) {
        data.add(item);
    }

    public static List<String> getData() {
        return data;
    }
}