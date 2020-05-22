public class LocaleOptionPane extends JFrame {

    public static void main(String[] args) {

        new LocaleOptionPane();
    }

    LocaleOptionPane() {

        Locale loc = new Locale("iw", "IL");
        String message = "<html><b><font color=\"#8F0000\" size=\"10\" face=\"Ariel\">" + "הכנס סטטוס חדש: " + "</font></p></html>";

        setVisible(true);

        JOptionPane pane = new JOptionPane(message, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
        pane.setWantsInput(true);

        JDialog dialog = pane.createDialog(this, UIManager.getString("OptionPane.inputDialogTitle", loc));
        dialog.getInputContext().selectInputMethod(loc); // pane.getInputContext... also works
        dialog.setVisible(true);
        dialog.dispose();

        String response = (String) pane.getInputValue();
        if (response == JOptionPane.UNINITIALIZED_VALUE)
            System.out.println("aborted");
        else
            System.out.println(response);
    }
}