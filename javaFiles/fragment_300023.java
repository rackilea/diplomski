public void itemStateChanged(ItemEvent e) {
    if (e.getStateChange() == ItemEvent.SELECTED) {
        //Do any operations you need to do when an item is selected.
    } else if(e.getStateChange() == ItemEvent.DESELECTED){
        //Do any operations you need to do when an item is de-selected.
    }
}