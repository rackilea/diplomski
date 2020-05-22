public void ShowTimePicker() {
    MyTimePicker myTimePicker = new MyTimePicker(this);
    myTimePicker.show();
    myTimePicker.setTimeListener(new onTimeSet() {

        @Override
        public void onTime(TimePicker view, int hourOfDay, int minute) {
            Toast.makeText(MainActivity.this,
                    "time is " + hourOfDay + ":" + minute,
                    Toast.LENGTH_LONG).show();

        }
    });
}