@Override
        protected void onPause() {
         super.onPause();


      if(locationManager != null) // add this line to your code
         locationManager.removeUpdates(this);
}