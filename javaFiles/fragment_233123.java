private Activity mainActivity;

public GPS(Activity activity){
   this.mainActivity =  activity;
   locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
}