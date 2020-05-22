public void init() {
    setLayout(new GridBagLayout());
    JButton browse = new JButton("...");
    browse.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setDialogTitle("Browse the folder to process");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setAcceptAllFileFilterUsed(false);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
                System.out.println("getSelectedFile() : "+ chooser.getSelectedFile());
            } else {
                System.out.println("No Selection ");
            }
        }
    });
    add(browse);
}