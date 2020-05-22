final StringComboBox searchGridTextBox = new StringComboBox();

searchGridTextBox.setEmptyText("Search Grid");
searchGridTextBox.addFocusHandler(new FocusHandler(){
@Override
public void onFocus(FocusEvent event){
    if(searchGridTextBox.getStore().size() > 0)
        searchGridTextBox.expand();

}
}); 
searchGridTextBox.addKeyUpHandler(new KeyUpHandler() {
@Override
public void onKeyUp(KeyUpEvent event) {
    System.out.println("On key up event ")   ;           
}
});