public class Disposing{
    private MainWindow mainWindowInstance;

    public Disposing(){
        mainWindowInstance = new MainWindow();
        .
        .
        .
    }

    public void diposeMainFrame(){
        mainWindowInstance.getMainFrame().dispose();
    }
}