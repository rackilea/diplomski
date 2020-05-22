public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == inputFile) {
        try {
            this.readInput();
        } catch (FileNotFoundException e) {
            // handle the exception
        }
    }
    if (source == decoder) {
        this.decode();
    }
}