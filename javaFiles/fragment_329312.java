private FlexTable flex = new FlexTable(); //it is a global variable
private HandlerRegistration handler = null;

private void A(){
    flex.clear();
    //
    if(handler != null){
        handler.removeHandler(); 
    }
    handler = flex.addClickHandler(new ClickHandler() {
    public void onClick(ClickEvent event) {
       //some code which might result into call of function B
    }
}