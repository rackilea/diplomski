public abstract class AbstractSaveAction extends GuiAction {
    // ...

    // for tests only. Consider naming as 'testFileDialog' if you prefer
    private FileDialog fileDialog = null;

    // for tests only
    protected void setFileDialog(FileDialog fileDialog) {
        this.fileDialog = fileDialog;
    }

    // for tests only
    protected void setController(Controller controller) {
        this.controller = controller;
    }

    protected FileDialog buildFileDialog(String title) {
        FileDialog result = null;

        if (this.fileDialog != null) {
            result = this.fileDialog;
        } else {
            result = new FileDialog(view, title, FileDialog.SAVE);
        }

        return result;
    }
    protected FileDialog getFileDialog(String title, final String extension) {
        // This is new. Get a FileDialog, and if in test-mode
        // so be it... It is a light-touch.
        FileDialog fileDialog = buildFileDialog(title);
        // ...
     }
}