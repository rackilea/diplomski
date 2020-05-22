Listener<BaseEvent> listener = new Listener<>() {
public void handleEvent(BaseEvent be) {
    boolean allSet = true;
    for (CheckBox child : listCheckBoxes) { 
        if (!child.getValue()) {
            allSet = false; // found a non-checked box
            break;
        }
    }
    allCheckBox.setValue(allSet); // this will also unselect if appropriate
}

// and set the listener to the children with
for (CheckBox box : listCheckBoxes) {
   box.addListener(Event.Clicked, listener);
}