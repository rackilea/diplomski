public class NewTab {

    private String tabName = "New Tab";

    // Creates a new tabbed pane with a text area
    protected JComponent createTab() {
        JTextArea ta = new JTextArea(10, 20);
        JScrollPane sp = new JScrollPane(ta);

        return ta;
    }

    public String getTabName() {
        // Could be used to hold the file name, for example
        return tabName;
    }

}