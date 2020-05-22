private void disableButtons(GridLayout layout) {

    // Get all touchable views
    ArrayList<View> layoutButtons = layout.getTouchables();

    // loop through them, if they are an instance of Button, disable it.
    for(View v : layoutButtons){
        if( v instanceof Button ) {
            ((Button)v).setEnabled(false);
        }
    }
}