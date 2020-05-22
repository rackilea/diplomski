public class Perspective implements IPerspectiveFactory {

    public void createInitialLayout(IPageLayout layout) {
    IFolderLayout folder = layout.createFolder("Folder", IPageLayout.LEFT, 0.5f, layout.getEditorArea());
    folder.addView(ContactsView.ID);
    folder.addView(IConsoleConstants.ID_CONSOLE_VIEW);
    }
}