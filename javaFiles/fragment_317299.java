private void setDay(boolean dayIncrement){

      Calendar cal = Calendar.getInstance(); //get an instance of Calenar
      int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //get the current day

switch (dayOfWeek) {

         //if it is monday....
case Calendar.MONDAY:

    text1.setText("some text for MONDAY");

    //if the plus button is pressed, the boolean dayIncrement is true
    if(dayIncrement==true){

         //then set the day of Calendar to the next day
         cal.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);

    //if the minus button is pressed, the boolean dayIncrement is false
    }else{

         //then set the day of Calendar to the previous day
         cal.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
     } 

    break;

case Calendar.TUESDAY:
    text1.setText("some Text for TU");

    if(dayIncrement==true){

         cal.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);

    }else{

         cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
     }

    break;

case Calendar.WEDNESDAY:
    text1.setText("WEn");

    if(dayIncrement==true){

         cal.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);

    }else{

         cal.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
     }

    break;

case Calendar.THURSDAY:
    text1.setText("TH");

    if(dayIncrement==true){

         cal.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);

    }else{

         cal.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
     }

    break;

case Calendar.FRIDAY:
    text1.setText("Fri");

    if(dayIncrement==true){

         cal.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);

    }else{

         cal.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
     }
    break;

case Calendar.SATURDAY:
    text1.setText("SAT");

     if(dayIncrement==true){

         cal.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);

    }else{

         cal.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
     }
    break;

case Calendar.SUNDAY:
    text1.setText("SAN");

    if(dayIncrement==true){

         cal.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);

    }else{

         cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
     }
    break;
   }
}