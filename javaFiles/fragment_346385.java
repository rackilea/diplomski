public void refreshOutlineView() {
    //get the activePage
    IWorkbenchPage wp =  PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    //Find desired view by its visual ID
    IViewPart myView=wp.findView("org.eclipse.ui.views.ContentOutline");

    //Hide the view :
    wp.hideView(myView);
    try {
      //show the view again     
      PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.ui.views.ContentOutline");
    } catch (PartInitException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 
}

@Override
protected void pageChange(int pageIndex) {
    refreshOutlineView();
    ....
    ....
    ....
}