Button button = new Button("Click Me!");
button.setStyleName(Button.STYLE_LINK);
button.addClickListener(new Button.ClickListener() {
    public void buttonClick(ClickEvent event) {
        // open your sub window here
        Window sub = new Window("Subwindow");
        v.addWindow(sub);
    }
});

v.addComponent(button);