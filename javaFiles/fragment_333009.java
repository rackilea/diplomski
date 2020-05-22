public class Initialize {

    public static void main(String[] args) {

        GUI.main(args);

        GUI objGUI = new GUI();
        Thread threadGUI = new Thread(objGUI);
        threadGUI.start();
    }
}