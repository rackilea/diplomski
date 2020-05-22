private boolean registerRecr=false;

@Override
protected void onRestart() {
    // TODO Auto-generated method stub
    super.onRestart();

    registerRecr=true;


}
@Override
protected void onStart() {
    // TODO Auto-generated method stub
    super.onStart();

}

@Override
protected void onResume() {
    // TODO Auto-generated method stub
    super.onResume();

}

 case R.id.action_refresh:
 removeAllMarkers();
 if(i.getBooleanExtra("maps", true)&& registerRecr==false) {
     mMyMarkersArray.add(new MyMarker(i.getStringExtra("nama"), i.getStringExtra("deskripsi"), i.getStringExtra("foto"), i.getStringExtra("marker"), Double.parseDouble(i.getStringExtra("lat")), Double.parseDouble(i.getStringExtra("lng"))));
     UI_HANDLER.postDelayed(UI_UPDATE_RUNNABLE, 500);
 }
 else {
     registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
 }
 getCurrentLocation();
 return true;