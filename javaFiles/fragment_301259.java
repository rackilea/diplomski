@Override
public void onBackPressed() 
{
   Intent myIntent = new Intent (Profile.this,FBLogin.class);
   myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
   myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
   myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
   startActivity(myIntent);
   super.onBackPressed();
}