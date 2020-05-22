public void onChannelButtonClick(View view) {    
    //assign it.
    subscribeChannel = String.valueOf(subscribeChannelEditText.getText());    
    String yourSubscribeChannel = "Subscribed to the " + subscribeChannel + " Channel";    
    Toast.makeText(this, yourSubscribeChannel, Toast.LENGTH_LONG).show();    
}