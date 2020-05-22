public void onClick(View v) {
    switch (v.getId()) {
    case R.id.button1:
        // Monday
       Intent intent = new Intent(MainActivity.this, Monday.class);
       startActivity(intent);
       break;
    case R.id.button2:
        // Tuesday
       Intent intent = new Intent(MainActivity.this, Tuesday.class);
       startActivity(intent);
       break;
    // the rest of the buttons go here
    default: Log.e("YourTAG", "Default in onClick hit!");
        break;
    }
}