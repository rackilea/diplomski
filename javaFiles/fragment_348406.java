private void addButton(Button button, String toolTip, FontAwesome fontAwesome, Button.ClickListener clickEvent){
    button = new Button(fontAwesome);
    button.setDescription(toolTip);
    button.setEnabled(false);
    button.addClickListener(clickEvent);
}