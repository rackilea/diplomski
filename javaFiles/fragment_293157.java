// In the App class: 

public static void main(String[] args) {
    try {
        loadingFrame = new LoadingFrame();
        loadingFrame.start();

        App window = new App();

        loadingFrame.stop();

        window.frame.setVisible(true);
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
}