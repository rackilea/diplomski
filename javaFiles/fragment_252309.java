protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  if (requestCode == x) { //x is the requestCode you chose above
     if(resultCode == RESULT_OK){
         String latitude=data.getStringExtra("latitude");
         String longitude=data.getStringExtra("longitude");
     } else if (resultCode == RESULT_CANCELED) {    
         //ActivityB was closed before you put any results
     }
  }
}