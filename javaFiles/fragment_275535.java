public class WebEngineTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        WebConsoleListener.setDefaultListener((webView, message, lineNumber, sourceId) -> {
            System.out.println(message + "[at " + lineNumber + "]");
        });

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.loadContent("<html><head><script>function openExcel() { app.open(); alert('hello world'); } </script></head><body><button onclick=\"openExcel()\">Open excel</button></body></html>");

        JSObject window = (JSObject) engine.executeScript("window");
        window.setMember("app", new OpenExcel());

        Scene scene = new Scene(webView, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class OpenExcel {

        public void open() {
            if (!Desktop.isDesktopSupported()) {
                throw new RuntimeException("Desktop is not supported");
            }

            try {
                File myFile = new File("C:\\Users\\HP\\Desktop\\v3.01.xlsm");
                // File myFile = new File("C:\\Users\\dzikoysk\\Desktop\\panda.txt");
                Desktop.getDesktop().open(myFile);
            } catch(IOException ex) {
                System.out.println("Your application is not support");
            }
        }

    }

}