if (v == btnstart) {
    Toast.makeText(getApplicationContext(), "Work Start", Toast.LENGTH_LONG).show();
//    Date d=new Date();

//    SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
//    String currentDateTimeString = sdf.format(d);
    startTime = System.currentTimeMillis();
    txtstart.setText(currentDateTimeString);
} else if (v == btnDone) {
    Toast.makeText(getApplicationContext(), "Work Done", Toast.LENGTH_LONG).show();
doneTime = System.currentTimeMillis();
takenTime = doneTime - startTime;
txtDone.setText(takenTime);
}