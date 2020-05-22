@Override  
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);  

    // Check if the request code corresponds to SecondActivity  
    // You can also check if resultCode has the value you were expecting
    if(requestCode==2) {
        // Retrieve the information passed. A message string in our case
        String message=data.getStringExtra("Message");
    }  
}