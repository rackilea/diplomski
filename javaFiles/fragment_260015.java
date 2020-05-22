OnMyPickerChangeListener pickerListener = new OnMyPickerChangeListener() {

    @Override
    public void onMyPickerChanged(String srcTxt) {          
        localTv.setText("Value: " + srcTxt);
    }
};