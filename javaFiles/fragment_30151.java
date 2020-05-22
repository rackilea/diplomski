public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 1) {
         if(resultCode == RESULT_OK){
             String stredittext=data.getStringExtra("edittextvalue");
         }     
    }
}