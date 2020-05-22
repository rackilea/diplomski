@SuppressLint("NewApi")
private void setTimePickerInterval(TimePicker timePicker) {
    try {
        Class<?> classForid = Class.forName("com.android.internal.R$id");

        Field fieldHr = classForid.getField("hour");
        mHourPicker = (NumberPicker) timePicker.findViewById(fieldHr.getInt(null));

        //set hours from 9am to 7pm (opening hours)
        mHourPicker.setMinValue(0);
        mHourPicker.setMaxValue(10);
        mDisplayedValuesHr = new ArrayList<String>();

        for (int i = 9; i < 20; i++) {
            mDisplayedValuesHr.add(String.format("%02d", i));
        }

        mHourPicker.setDisplayedValues(mDisplayedValuesHr.toArray(new String[0]));

        Field fieldMin = classForid.getField("minute");
        mMinutePicker = (NumberPicker) timePicker.findViewById(fieldMin.getInt(null));

        //set minutes in 15 mins interval
        mMinutePicker.setMinValue(0);
        mMinutePicker.setMaxValue(3);
        mDisplayedValuesMin = new ArrayList<String>();

        for (int i = 0; i < 60; i += TIME_PICKER_INTERVAL) {
            mDisplayedValuesMin.add(String.format("%02d", i));
        }

        mMinutePicker.setDisplayedValues(mDisplayedValuesMin.toArray(new String[0]));
        mMinutePicker.setWrapSelectorWheel(true);

    } catch (Exception e) {
        e.printStackTrace();
    }
}