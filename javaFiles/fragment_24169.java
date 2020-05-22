private Button newModButton() {
    Button modButton = new Button("Modify");
    modButton.addClickHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
            //TODO: link to a pop-up, and do a refresh on exit
        }
    });
    return modButton;
}