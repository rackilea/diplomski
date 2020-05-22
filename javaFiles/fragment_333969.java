static boolean isNewUser;
public static void main(String[] args) throws InvocationTargetException, InterruptedException {
    SwingUtilities.invokeAndWait(new Runnable() {
        @Override
        public void run() {
            isNewUser = isNewUser();
        }
    });
    System.out.println("Is new user: " + isNewUser);
}

public static boolean isNewUser() {
    Object[] options = { "Existing User", "New User" };
    int resp = JOptionPane.showOptionDialog(null, "Hello, click one of the above to continue!", "User Type", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    return resp == JOptionPane.NO_OPTION;
}