JFileChooser chooser = new JFileChooser() {
    // put in all the routines as listed earlier
};
chooser.setAcceptAllFileFilterUsed(true);
int choice = chooser.showOpenDialog(null);
if (choice == JFileChooser.APPROVE_OPTION) {
    String name = chooser.getSelectedFile().getAbsolutePath();
    System.out.println(name);
}