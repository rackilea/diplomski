@Override
protected void onResume() {
    super.onResume();
    try {
      MApplication.sBus.register(this);
    }
   catch(Exception e){
      e.printStackTrace();
   }
}

@Override
protected void onDestroy() {
    super.onDestroy();
   try {
      MApplication.sBus.unregister(this);
    }
   catch(Exception e){
      e.printStackTrace();
   }
}