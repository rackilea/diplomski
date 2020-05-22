public class Testing {

    // Public class variables
    public static int arrayX, arrayY, array[][];

    public static void main(String[] args) {

        // Start menu instance
        new StartGUI();
    }

    public static void StartGUIFinished() {

        // MenuGUI sets arrayX and arrayY
        array = new int[arrayX][arrayY];
        // More code here...
    }
}