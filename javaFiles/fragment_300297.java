long lastTimeSent = 0; //start at 0


sentSMS.setOnClickListener(new OnClickListener() {
public void onClick(View v) {

   if(System.currentTimeMillis() > lastTimeSent + 10000){ //if at least 10 secs has passed from last click
       processClick();
       lastTimeSent = System.currentTimeMillis(); //last time sent is now current time
   }else{
       Toast.makeText(getBaseContext(), "Spam protection, please wait.",
                        Toast.LENGTH_SHORT).show();
   }
}});