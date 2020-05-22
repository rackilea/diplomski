IActionBars actionBars = getViewSite().getActionBars();
actionBars.setGlobalActionHandler(ActionFactory.RENAME.getId(), new Action()
{
  @Override
  public void run()
  {
    ISelection viewSelection = viewer.getSelection();
    if (viewSelection instanceof IStructuredSelection)
    {
      IStructuredSelection selection = (IStructuredSelection)viewSelection;
      Object o = selection.getFirstElement();

      ....
    }
  }
});