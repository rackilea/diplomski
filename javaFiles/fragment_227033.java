AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
//...All your code to set up the buttons initially

AlertDialog dialog = alertbox.create();
Button button = dialog.getButton(AlertDialog.BUTTON_NEUTRAL);
if(monsterint > playerint) {
    button.setEnabled(false);
}