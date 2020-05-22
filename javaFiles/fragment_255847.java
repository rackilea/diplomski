final Calendar c = Calendar.getInstance();
    TimePicker alarm_time_picker = (TimePicker) findViewById(R.id.timePicker);



alarm_time_picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

    int hour = alarm_time_picker.getHour(); //get selected hour
    int minute = alarm_time_picker.getMinute();


int hour_now = c.get(Calendar.HOUR); //get system's hour
int minute_now = c.get(Calendar.MINUTE); //get system's minute

int hour_result = hour - hour_now; //subtract the time selected by time.now of system
int minute_result = minute - minute_now;

String hour_result_string = String.valueOf(hour_result); //convert to string to display
String minute_result_string = String.valueOf(minute_result);

setToast_result("Alarm set to " + hour_result_string + " hours " + minute_result_string + " minutes");

}