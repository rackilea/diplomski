public void preWindowOpen() {
    IWorkbenchWindowConfigurer configurer = getWindowConfigurer();

    configurer.addEditorAreaTransfer(EditorInputTransfer.getInstance());
    configurer.addEditorAreaTransfer(ResourceTransfer.getInstance());
    configurer.addEditorAreaTransfer(FileTransfer.getInstance());
    configurer.addEditorAreaTransfer(MarkerTransfer.getInstance());

    configurer.configureEditorAreaDropListener(new EditorAreaDropAdapter(
            configurer.getWindow()));