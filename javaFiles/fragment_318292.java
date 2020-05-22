new CheckBox("id", model) { 
    protected boolean wantOnSelectionChangedNotifications() {
     return true;
 } 
    protected void onSelectionChanged(Boolean newSelection) {
     // do something, page will be rerendered; 
} };