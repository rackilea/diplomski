changedlistener = new OnWheelChangedListener() {
   boolean inProgress = false;

   public void onChanged(WheelView wheel, int oldValue, int newValue) {

     if (!inProgress) {
         return;
     }
     inProgress = true;

     try {
         if (wheel.getId() == R.id.month || wheel.getId() == R.id.day || wheel.getId() == R.id.year) {
             updateDays(year, month, day);
         } else if (wheel.getId() == R.id.hijrimonth || wheel.getId() == R.id.hijriday || wheel.getId() == R.id.hijriyear) {
             hijriDays(hijriyear, hijrimonth, hijriday);
         }
      }
      finally {
          inProgress = false;
      }
   }
};