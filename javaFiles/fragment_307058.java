public class YourAction extends DumbAwareAction {
    ...
    @Override
    public void update(AnActionEvent e) {
        super.update(e);
        determineVisibility(e);
    }

    private void determineVisibility(AnActionEvent e) {
        DataContext dataContext = e.getDataContext();
        VirtualFile virtualFile = PlatformDataKeys.VIRTUAL_FILE.getData(dataContext);
        e.getPresentation().setVisible(isXml(virtualFile));
    }

    private boolean isXml(VirtualFile file) {
        if (file == null) {
            return false;
        }
        return XmlFileType.INSTANCE.equals(file.getFileType());
    }
}