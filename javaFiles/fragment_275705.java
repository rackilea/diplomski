public class Main {

    private static JFrame mainWindow; // declare it here so it can be seen from your main method.

    public static void makeWindow(){
        mainWindow = new JFrame();
        mainWindow.setVisible(true);
        mainWindow.setPreferredSize(new Dimension(400,400));
        mainWindow.pack();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
    }

    public static void main(String args[]){
        makeWindow();
        JPanel mainPanel = new JPanel();
        mainWindow.add(mainPanel);
    }
}