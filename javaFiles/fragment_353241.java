//create intent
Intent intent = new Intent(getApplicationContext(),ChooseUserActivity.class);

//put extras
intent.putExtra("Name",imageName);

//start activity
startActivity(intent);