public void createPartControl(Composite parent) {
  IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
    .getActivePage();
  IViewReference ref = page.findViewReference(IConsoleConstants.ID_CONSOLE_VIEW);
  IOConsole  console = createConsole(); // here create new console

  // this will ad console page to corresponding view                
        IPageBookViewPage pageBook = targetConsole.createPage(this);
        try {
            pageBook.init(new PageSite((IViewSite) ref.getView(true).getSite()));
        } catch (PartInitException e) {
            e.printStackTrace();
        }
        pageBook.createControl(parent);

}