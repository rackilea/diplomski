@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
   if(requestCode == LOGIN_CODE) { // this code you should provide in startActivityForResult
      this.finish();
   }
}