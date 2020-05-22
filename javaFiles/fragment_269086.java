private class DoubleClickListener implements IDoubleClickListener
{
  @Override
  public void doubleClick(final DoubleClickEvent event)
  {
    final IStructuredSelection selection = (IStructuredSelection)event.getSelection();
    if (selection == null || selection.isEmpty())
      return;

    final Object sel = selection.getFirstElement();

    final ITreeContentProvider provider = (ITreeContentProvider)treeViewer.getContentProvider();

    if (!provider.hasChildren(sel))
      return;

    if (treeViewer.getExpandedState(sel))
      treeViewer.collapseToLevel(sel, AbstractTreeViewer.ALL_LEVELS);
    else
      treeViewer.expandToLevel(sel, 1);
  }
}