//constructor
public Editor() {
    tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
    add(tabs, BorderLayout.CENTER);
}

//class method
void addFile(String name) {
    tabs.addTab(name, new JScrollPane(new TextArea()));
}