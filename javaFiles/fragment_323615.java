public static float HoursToFloat(String tmpHours) throws NumberFormatException {
     float result = 0;
     tmpHours = tmpHours.trim();

     // Try converting to float first
     try
     {
        result = new Float(tmpHours);
     }
     catch(NumberFormatException nfe)
     {
         // OK so that didn't work.  Did they use a colon?
         if(tmpHours.contains(":"))
         {
             int hours = 0;
             int minutes = 0;
             int locationOfColon = tmpHours.indexOf(":");
             try {
                  hours = new Integer(tmpHours.substring(0, locationOfColon-1));
                  minutes = new Integer(tmpHours.substring(locationOfColon+1));
             }
             catch(NumberFormatException nfe2) {
                  //need to do something here if they are still formatted wrong.
                  //perhaps throw the exception to the user to the UI to force the user
                  //to put in a correct value.
                  throw nfe2;
             }

             //add in partial hours (ie minutes if minutes are greater than zero.
             if(minutes > 0) {
                 result = minutes / 60;
             }

             //now add in the full number of hours.
             result += hours;
         }
     }

     return result;
 }