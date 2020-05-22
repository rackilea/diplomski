private FlexTable flex = new FlexTable(); //it is a global variable
private ClickHandler handler = null;

private void A(){
    flex.clear();
    //
    if(handler == null){
        handler = new ClickHandler(){}...
        flex.addHandler(handler);
    }