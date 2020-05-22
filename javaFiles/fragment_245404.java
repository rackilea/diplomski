YourButton.setOnClickListener(new OnClickListener() 
 {
 @Override          
 public void onClick(View v) 
 {  

Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
startActivity(intent);

}         
});