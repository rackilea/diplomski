String inputDateInString = "Aug 29 2011 2:24PM";                
DateFormat formatter = new SimpleDateFormat("MMM dd yyyy h:mmaa");
try {
    Date dateObject = formatter.parse(inputDateInString);

    String date = new SimpleDateFormat("dd/MM/yyyy").format(dateObject);
    String time = new SimpleDateFormat("h:mmaa").format(dateObject);
} catch (ParseException e) {
 e.printStackTrace();
}