try {               
    IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    if ( part instanceof ITextEditor ) {
        final ITextEditor editor = (ITextEditor)part;
        IDocumentProvider prov = editor.getDocumentProvider();
        IDocument doc = prov.getDocument( editor.getEditorInput() );
        ISelection sel = editor.getSelectionProvider().getSelection();
        if ( sel instanceof TextSelection ) {

            // Here is your String
            final TextSelection textSel = (TextSelection)sel;

        }
    }
} catch ( Exception ex ) {
    ex.printStackTrace();
}