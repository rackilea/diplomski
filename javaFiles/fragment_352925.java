IEditorPart editor = ...;  
IEditorInput input = editor.getEditorInput();  
IDocument document=(((ITextEditor)editor).getDocumentProvider()).getDocument();

document.addDocumentListener(new IDocumentListener() {

        @Override
        public void documentChanged(DocumentEvent event) 
        {
            System.out.println("Change happened: " + event.toString());
        }

        @Override
        public void documentAboutToBeChanged(DocumentEvent event) {
            System.out.println("I predict that the following change will occur: "+event.toString());


        }
    };
});