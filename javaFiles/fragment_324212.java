button.addClickListener(new Button.ClickListener() {
    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {
        Notification.show("You are at: " + Page.getCurrent().getLocation());
    }
});