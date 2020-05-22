Listener<BaseEvent> listener = new Listener<>() {
    public void handleEvent(BaseEvent be) {
        boolean allSet = listCheckBoxes.stream().allMatch(CheckBox::getValue);
        allCheckBox.setValue(allSet); // this will also unselect if appropriate
    }
 }