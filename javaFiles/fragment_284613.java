public void onModuleLoad() {

    ImageHolder imageHolder = new ImageHolder();
    RootPanel.get().add(imageHolder.panel);

    ImageHolder.initiateFilesInput(imageHolder.fileUpload.getElement(), imageHolder);
}