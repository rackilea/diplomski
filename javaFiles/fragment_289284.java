public void onCreateOptionsMenu(Menu menu){
    ....
    actionProvider.setOnShareTargetSelectedListener(this);
    ....


 @Override 
 public boolean onShareTargetSelected(ShareActionProvider source, 
         Intent intent) { 

     context.startActivity(intent); 

     // started activity ourself to prevent search history 
     return true; 
 }