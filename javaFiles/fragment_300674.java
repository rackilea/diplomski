ISelection sel = HandlerUtil.getCurrentSelection(event);

if (sel instanceof IStructuredSelection)
 {
   Object selObj = ((IStructuredSelection)sel).getFirstObject();

   IFile file = (IFile)Platform.getAdapterManager().getAdapter(selObj, IFile.class);

   // TODO your code
 }