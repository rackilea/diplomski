public static void main(String[] args) throws IOException {

    FileChooser fileChosen = new FileChooser();
    fileChosen.showFileDialogDemo();

    String fileName = fileChosen.getFilePath();
    // This is called as soon as mainFrame is hidden
    System.out.println(fileName);
}

public static class FileChooser {

    private String filePath;
    // This is now a Dialog instead of a frame
    private Dialog mainFrame;

    public FileChooser() {
        prepareGUI();
    }

    private void prepareGUI() {
        // APPLICATION_MODAL makes sure the code is blocked once mainFrame is shown.
        mainFrame = new Dialog(null, "Naufal File Chooser", Dialog.ModalityType.APPLICATION_MODAL);
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void showFileDialogDemo() {
        Button showFileDialogButton = new Button("Open File");
        showFileDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(mainFrame, "Select file");
                fileDialog.setVisible(true);
                setFilePath(fileDialog.getDirectory() + fileDialog.getFile());
                // This is to make sure the code resumes where it was blocked
                mainFrame.setVisible(false);
            }
        });
        mainFrame.add(showFileDialogButton);
        mainFrame.setVisible(true);
    }

    public void setFilePath(String file) {
        this.filePath = file;
    }

    public String getFilePath() {
        return filePath;
    }
}