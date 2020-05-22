Date date = new Date();
String dateOb = "";
boolean correctFormat = false;
do {
    (...)
    date = new SimpleDateFormat("dd/MM/yyyy").parse(dateOB);
    (...)
} while (...);
int dayNmonth = Integer.parseInt(new SimpleDateFormat("ddMM").format(date);
(...)
cal.setTime(date);
(...)