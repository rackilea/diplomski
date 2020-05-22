private void checkAndSetImage()
{
     SharedPreferences settings = getSharedPreferences("status", 0);
     if(settings.getBoolean("orange", false))
     {
         imBuOn.setImageResource(R.drawable.orange);
     }
}