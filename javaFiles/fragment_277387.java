public class Lab5 {

/**
* Return true if the given date/time is daylight savings.
* Daylight savings time begins 2am the second Sunday of March and ends 2am the first     Sunday of November.
* 
* @param month - represents the month with 1 = January, 12 = December
* @param date - represents the day of the month, between 1 and 31
* @param day - represents the day of the week with 1 = Sunday, 7 = Saturday
* @param hour - represents the hour of the day with 0 = midnight, 12 = noon
* 
* Precondition: the month is between 1 and 12, the date is between 1 and 31, the day is between 1 and 7
*                and the hour is between 0 and 23.
*/
public static boolean isDayLightSavings (int month, int date, int day, int hour) {
  if (month == 1 || month == 2 || month == 12)
    return false;
  else if (month == 11) {
    if (date > 7)  // after 7th, it would be second week'day' of the month
      return false;
    else if ((date - day) >= 0) { 
      // As we ruled out all dates above 7, we would get only 1-7
      // here. Now, lets take 3rd as Monday, date == 3, day == 2
      // so we know that 2 is Sunday. that means if date - day is positive or zero,
      // Sunday is already past. one border case is, when Sunday falls on the date entered and we
      // we need to consider the first 2 hours of the day
      if((day == 1) && (hours < 2))
        return true;
      else
        return false;
    }
    else {
      // we will come here if date - day is less than zero
      // example, 3rd came on Thursday, 3 - 5 = -2 and so
      // first sunday is not yet past
      return true;
    }            

  }
  else
    return true;    
 }
}