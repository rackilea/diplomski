@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

 if (requestCode == 500) { //Remember the result code we set in startActivityForResult()? This is how we identify our incoming data
     if(resultCode == Activity.RESULT_OK){  //Data is received
        String result= data.getStringExtra("tvresult1"); 
        //Your result is received
     } 
   }
}