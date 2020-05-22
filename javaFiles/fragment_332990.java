class MyUpload extends Composite {
    private static native void clickOnInputFile(Element elem) /*-{
        elem.click();
    }-*/;

    public MyUpload() {
        final FileUploadWithMouseEvents upload = new FileUploadWithMouseEvents();
        AbsolutePanel container = new AbsolutePanel();
        container.add(upload);
        upload.setVisible(false);
        Button btn = new Button("My Browse..");
        btn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                clickOnInputFile(upload.getElement());
            }
        });
        container.add(btn);
        initWidget(container);
    }
}