frame.setDefaultCloseOperation(setDefaultCloseOperation);
frame.addWindowListener(new SaveOnCloseWindowListener(fileState));
...

public class SaveOnCloseWindowListener extends WindowAdapter {
    private final FileState fileState;

    public SaveOnCloseWindowListener(FileState fileState) {
        this.fileState = fileState;
    }

    public void windowClosing(WindowEvent e) {
        if (fileState.onQuit())
            frame.dispose();
    }
}