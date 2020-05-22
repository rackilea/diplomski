public static ToolsSource getInstance(Context context) {
    if (instance == null) {
        try {
            instance = new ToolsSource(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    return instance;
}