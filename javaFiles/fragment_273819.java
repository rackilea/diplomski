public class UserInfoEditorPane extends JPanel {
    private JSpinner jage;
    private JSpinner jheight;
    private JSpinner jweight;

    public UserInfoEditorPane() {  
        // Set the UI as you want...
    }

    public Collectdata getUserInfo() {
        // Create a new instance of Collectdata
        // and populate it with the values from
        // the fields...
        Collectdata data = ...;
        //...
        return data;
    }
}