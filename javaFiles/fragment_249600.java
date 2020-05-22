public class MyApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MyFrameManager f = new MyFrameManager();
                f.showInterface(PossibleInterfacesEnum.INTERFACE_1);
            }
        });
    }
}