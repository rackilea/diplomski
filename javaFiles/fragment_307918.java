private class MyListener implements NumberPicker.OnValueChangeListener {
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        //get new value and convert it to String
        //if you want to use variable value elsewhere, declare it as a field 
        //of your main function
        String value = "" + newVal;
    }
}