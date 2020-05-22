if(android.os.Build.VERSION.SDK_INT >= 11){ // Honeycomb
{
  AsyncTask taskObj = new DefaultAsyncTaskImpl();
  taskObj.execute();  
} else {
  AsyncTask taskObj = new CustomAsyncTaskImpl();
  taskObj.execute();
}