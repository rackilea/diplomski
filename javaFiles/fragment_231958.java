int resourceId = 0;
 switch (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
     case Calendar.SUNDAY:
         resourceId = R.id.sundayView;
         break;

     case Calendar.MONDAY:
         resourceId = R.id.mondayView;
         break;

     ...etc
 }

ImageView image = (ImageView) findViewById(resourceId);