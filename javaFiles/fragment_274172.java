// setup data
Intent intent = new Intent(this, SecondActivity.class);
intent.putSerializable("my_key", personObject);
startActivity(intent);

// retrieve data in second activity
Person myPerson = getIntent().getExtras().getSerializable("my_key");