public void fillArray() {

View inflatedView = getLayoutInflater().inflate(R.layout.add_activity, null);
np_hours = ( NumberPicker ) inflatedView.findViewById( R.id.hourNumber );
np_hours.setMaxValue(24);
np_hours.setMinValue(0);

np_minutes = ( NumberPicker ) inflatedView.findViewById( R.id.minuteNumber );
np_minutes.setMaxValue(60);
np_minutes.setMinValue(0);

}