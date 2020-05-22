int[] loc = {0,0};
View tempView = (View) findViewById(R.layout.main);
if (tempView != null) {
    tempView.getLocationOnScreen(loc);
} else {
    Log.d("YourComponent", "tempView was null.");
}