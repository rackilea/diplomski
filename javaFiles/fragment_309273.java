public void onClick(View v){
    // note in the below line i'm just using "this"
    Intent myIntent = new Intent(this, Main2Activity.class)
    // Secondly, you need to end the current activity
    finish();
    // Third, you need to start your new activity... 
    //    Creating an Intent does not the activity alone
    startActivity(myIntent);
}