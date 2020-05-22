//create the new intent; it will refer to the new activity
Intent intent = new Intent(this, NewActivity.class);

//pass any data to the new activity; cancel this line if you don't need it
intent.putExtra(extra_title, extra)

//start the new activity
startActivity(intent);