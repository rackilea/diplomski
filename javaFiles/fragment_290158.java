@Override
public boolean isEditable() {
    IDocumentProvider provider= getDocumentProvider();
    if (provider instanceof IDocumentProviderExtension) {
        IDocumentProviderExtension extension= (IDocumentProviderExtension) provider;
        return extension.isModifiable(getEditorInput());
    }
    return false;
}