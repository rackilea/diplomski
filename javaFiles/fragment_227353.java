@Override
protected void onBackPressed(){
    //super.onBackPressed(); //remove it if you want control
    String previousDir = "build your previous dir here";
    if (previousDir != null){ //if deferent root path
       Intent activityDir = new Intent(this, MainActivity.class);
       activityDir.putExtra("DIR_PATH", previousDir);
       startActivity(activityDir);
    }//end if

   finish(); //close this screen to show new screen above with new path
}