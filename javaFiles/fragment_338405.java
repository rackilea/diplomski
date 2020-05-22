//method for parsing date
public static String dateParsing(String date) {
 Date newDate;
 String returnDate = "";
 if (isValidDate(date)) {
  returnDate = date;
  return returnDate;
 } else {
  Log.e("DB", "date===>" + date);
  try {
   newDate = formatter.parse(date);
   Log.e("DB", "New Date===>" + newDate);
   returnDate = formatterString.format(newDate);
   Log.e("DB", "returnDate===>" + returnDate);
  } catch (ParseException e) {
   e.printStackTrace();
  }
 }

 return returnDate;
}