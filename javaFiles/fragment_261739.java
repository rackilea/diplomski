String d1="12-27-2010";
    Stirng[] splitdata=d1.split("-");

   int month=Integer.parseInt(splitdata[0]);
 int day=Integer.parseInt(splitdata[1]);
int year=Integer.parseInt(splitdata[2]);

Calender cal=Calender.getInstance(Locale.CHINA);
cal.set(year,month,day);
Date d=cal.getTime();