Calendar calendar = Calendar.getInstance();
Date myDate = new Date(); // as an example, date of "now"
calendar.setTime(myDate);

int day = calendar.get(Calendar.DAY_OF_MONTH);
int monthNumber = calendar.get(Calendar.MONTH);

String[] _months = new DateFormatSymbols().getMonths();
String[] months = new String[12];
for(int i =0; i < 12; i++){
    months[i] = _months[i];
}
//because there is something wrong, we have a 12. month in the name of "" (nothing)

//or if there is no DateFormatSymbols class in your plans
//you may write for yourself;
/*
String[] monthNames = {"January", "February",
            "March", "April", "May", "June", "July",
            "August", "September", "October", "November",
            "December"};
*/
String month = months[monthNumber]; //or String month = monthNames[monthNumber];

int year = calendar.get(Calendar.YEAR);

int hour = calendar.get(Calendar.HOUR);
int minute = calendar.get(Calendar.MINUTE);
String amPm = calendar.get(Calendar.AM_PM)==1 ? "am" : "pm";
System.out.println(day + " " + month + " " + 
    year + ", " + hour + ":" + minute + amPm);