@Override
public void postStartup() {
    :
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        page.showView("org.eclipse.help.ui.HelpView");
    :
}