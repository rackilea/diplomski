static PasswordStorageWindow PasswordStorageWindow; // Not initialized anywhere

private JFrame frame;
private JTextField passwordField;
private JTextField usernameField;

public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                // You are passing a null value here, PasswordStorageWindow is not initialized.
                AddNewPasswordWindow window = new AddNewPasswordWindow(PasswordStorageWindow); 
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}