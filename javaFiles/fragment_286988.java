@UiHandler("button")
void onClick(ClickEvent e) {

    Object soruce = e.getSource();

    if(soruce instanceof Button){
        String buttonText = ((Button)soruce).getText();
        RootPanel.get().add(new Label(buttonText));
    }
    else {
        RootPanel.get().add(new Label("The event is not bound to a button"));
    }
}