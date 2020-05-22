@Override 
public void onBackPressed() {
super.onBackPressed();
i = new Intent(CurrentActivity.this, NextActivity.class);
i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
startActivity(i);
finish();
}