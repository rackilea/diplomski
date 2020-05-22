public class Main {

    public static JFrame makeWindow(){
        JFrame mainWindow = new JFrame();
        mainWindow.setVisible(true);
        mainWindow.setPreferredSize(new Dimension(400,400));
        mainWindow.pack();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocationRelativeTo(null);
        return mainWindow;
    }

    public static void main(String args[]){
        JFrame mainWindow = makeWindow();
        JPanel mainPanel = new JPanel();
        mainWindow.add(mainPanel);
    }
}