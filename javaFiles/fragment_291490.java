while(true) //Equivalent to what you had 
{ 
      if(hrs == 19 && mins == 00) {
           JOptionPane.showMessageDialog(frame,
               "It's 7:00 PM!",
               "Time Alert",
               JOptionPane.WARNING_MESSAGE);
           System.exit(0);
           break;
       }
       //Refresh your hrs and mins here
       Calendar calendar = GregorianCalendar.getInstance(); // Probably dont really want to actually get an instance every time
       hrs = calendar.get(Calendar.HOUR_OF_DAY);
       mins = calendar.get(Calendar.MINUTE);
}