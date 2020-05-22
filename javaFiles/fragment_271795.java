boolean allDisabled = true;

loop:
for(int row = 0; row < buttons.length; row++){
    for(int column = 0; column<buttons[row].length; column++){

        if(buttons[row][column].isEnabled()){
            //This button is enabled, so we set allDisabled to false
            allDisabled = false;
            break loop;
        }

    }
}