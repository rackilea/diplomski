public class UserGui extends JFrame {
    public UserGui() {}

    public void showGui() {
        setVisible(true);
    }
}

public class Demo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                  final UserGui GUI = new UserGui();
                  GUI.showGui();
             }

        });
    } 
}