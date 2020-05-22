public class TreeDoubleClickListener implements IDoubleClickListener
{
  @Override
  public void doubleClick(final DoubleClickEvent event)
  {
    IStructuredSelection selection = (IStructuredSelection)event.getSelection();
    if (selection == null || selection.isEmpty())
      return;

    Object sel = selection.getFirstElement();

    TreeViewer treeViewer = (TreeViewer)event.getViewer();

    IContentProvider provider = treeViewer.getContentProvider();

    if (provider instanceof ITreeContentProvider)
     {
       ITreeContentProvider treeProvider = (ITreeContentProvider)provider;

       if (!treeProvider.hasChildren(sel))
         return;

       if (treeViewer.getExpandedState(sel))
         treeViewer.collapseToLevel(sel, AbstractTreeViewer.ALL_LEVELS);
       else
         treeViewer.expandToLevel(sel, 1);
     }
  }
}