final TabSheet tabSheet = new TabSheet();

Button button = new Button("Add the tab");
button.addListener(new Button.ClickListener(){
    public void buttonClick(ClickEvent event) {
        VerticalLayout content = new VerticalLayout();
        content.addComponent(new Label("This is the tab content."));
        Tab tab = tabSheet.addTab(content, "The new Tab", null);
    }
}