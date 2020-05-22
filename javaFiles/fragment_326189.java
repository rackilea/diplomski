@Override
protected void onDestroy()
{
   endTime = System.currentTimeMillis();
   long timeSpend = endTime - startTime;
   // Insert timeSpend in databse.
   // you can also convert the timeSpend to hours, minutes, seconds.
   super.onDestroy();
}