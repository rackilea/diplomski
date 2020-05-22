public void onChannelButtonClick(View view) {    
    //here you set it and then it's lost.
    String subscribeChannel = String.valueOf(subscribeChannelEditText.getText());    
    String yourSubscribeChannel = "Subscribed to the " + subscribeChannel + " Channel";    
    Toast.makeText(this, yourSubscribeChannel, Toast.LENGTH_LONG).show();    
}