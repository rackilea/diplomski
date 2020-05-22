ArrayAdapter myAdap = (ArrayAdapter) spinner1.getAdapter();
         if (Message.getID() == id) {
        previousSelected = Message.getSpinnerPosition();
        int spinnerPosition = myAdap.previousSelected;
        spinner1.setSelection(spinnerPosition);
}