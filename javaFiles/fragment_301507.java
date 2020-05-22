//initalize stage and all your buttons
ButtonGroup buttonGroup = new ButtonGroup(button1, button2, button3, etc...)
//next set the max and min amount to be checked
buttonGroup.setMaxCheckCount(1);
buttonGroup.setMinCheckCount(0);
//it may be useful to use this method:
setUncheckLast(true); //If true, when the maximum number of buttons are checked and an additional button is checked, the last button to be checked is unchecked so that the maximum is not exceeded.