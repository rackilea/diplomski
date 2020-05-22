public abstract class OpenFileAction extends AbstractAction {
    JFrame frame;
    JFileChooser chooser;

    public OpenFileAction(JFrame frame, JFileChooser chooser) {
        super("Open...");
        this.chooser = chooser;
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent evt) {
        int option = chooser.showOpenDialog(this.frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            doWithSelectedFile(selectedFile)
        }
    }

    /**
     * Method to override, which gets called with the selected file.
     */
    protected abstract doWithSelectedFile(File file);
}

...

OpenFileAction action = new OpenFileAction(frame, new JFileChooser(new File("."))) {
    @Override
    protected void doWithSelectedFile(File file) {
        // do what you want here
    }
};
JButton button = new JButton(action);