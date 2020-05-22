@Override 
protected void onPause() 
{ 
   Log.v(LOG_TAG, "onPause()");
   Intent data = new Intent();
   data.putExtra(MainActivity.EXTRA_SEARCH, searchStr);
   if (getParent() == null) { 
      setResult(Activity.RESULT_OK, data);
   } else { 
      getParent().setResult(Activity.RESULT_OK, data);
   } 
   Log.v(LOG_TAG, "Activity.RESULT_OK" + in);
   super.onPause(); 
}