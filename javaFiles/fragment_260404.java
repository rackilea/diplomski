if (opt == JOptionPane.CANCEL_OPTION) {
    //Do nothing
} else if (opt == JOptionPane.NO_OPTION) {
    removeTabs();
} else {
    Tab temp = StaticVariables.tablist.get(tabbedPane.getSelectedIndex());
    FileAction fa = new FileAction();
    fa.FileSaveaction(temp);
    removeTabs();
}