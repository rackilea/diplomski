private OnTimeSetListener timeSetListener = new OnTimeSetListener() {
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        activeTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        activeTime.set(Calendar.MINUTE, minute);
        updateTimeDisplay(activeTimeDisplay, activeTime);
        unregisterTimeDisplay();
    }
};