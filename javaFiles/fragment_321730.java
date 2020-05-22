final FormPanel formPanel = new FormPanel();
FileUpload fileUpload = new FileUpload();
formPanel.add(fileUpload);
Button button = new Button("Clear value");
button.addClickHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
            formPanel.reset();

    }
});