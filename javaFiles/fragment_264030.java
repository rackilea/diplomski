@Override
public void onBackPressed() {
    Intent i= new Intent(your_present_activity.this,the_activity_you_want_to_jump_to.class);
    startActivity(i);
    finish();
}