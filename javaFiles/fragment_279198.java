public void setMenuBarItems(JMenuBar menuBar) {
    JMenu file = new JMenu("File");
    menuBar.add(file);
    JMenuItem open = new JMenuItem("Open");
    file.add(open);
    JMenuItem neww = new JMenuItem("New");
    file.add(neww);

    JMenu edit = new JMenu("Edit");
    menuBar.add(edit);
    JMenuItem color = new JMenuItem("Change Color");
    edit.add(color);

    JMenu help = new JMenu("Help");
    menuBar.add(help);
    JMenuItem about = new JMenuItem("About");
    help.add(about);
}