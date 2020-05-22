Intent intent = getIntent();
int activityNumber = intent.getIntExtra("activity", 0);

if (activityNumber == 1) {
    //do something
} else{
    finish();
}