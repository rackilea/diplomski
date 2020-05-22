if (editorInput instanceof IURIEditorInput)
 {
   IURIEditorInput uriInput = (IURIEditorInput)editorInput;

   URI uri = uriInput.getURI();

   File file = new File(uri);

   ... test path

   .. get document contents in the same way
 }