public class ExceptionHandler {
    public void handleException(Exception exp) {
        if (exp instanceof NullPointerException) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Jokes Files Missing", "File Missing",
                    JOptionPane.ERROR_MESSAGE);
        } else if (exp instanceof IOException) {
            javax.swing.JOptionPane.showMessageDialog(null, "Test", "Test",
                    JOptionPane.ERROR_MESSAGE);
        }
        //Handle other exceptions
    }
}