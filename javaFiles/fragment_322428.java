private void display() {
    …
    JTabbedPane jtp = new JTabbedPane();
    for (String s : titles) {
        jtp.add(createPane(s));
    }
    …
}