IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

if (editor instanceof ITextEditor)
 {
   ITextEditor textEditor = (ITextEditor)editor;

   IDocumentProvider provider = textEditor.getDocumentProvider();

   IEditorInput input = editor.getEditorInput();

   IDocument document = provider.getDocument(input);

   String text = document.get();

   ...
 }