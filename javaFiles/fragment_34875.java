@Override 
 public void onActivityResult(int requestCode, int resultCode, Intent data) {
 // TODO Auto-generated method stub 
 if(requestCode == "123" && resultCode == Activity.RESULT_OK){
 Log.i("called","called");
 //add your logic here
 } 
 super.onActivityResult(requestCode, resultCode, data);
 }