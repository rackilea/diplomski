GregorianCalendar calendar1 = new GregorianCalendar();
calendar1.setTime(date1);
// Edit the calendar1 here if you want to

GregorianCalendar calendar2 = new GregorianCalendar();
calendar2.setTime(date2);
calendar2.add(GregorianCalendar.DAY_OF_YEAR, 1);

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
TimeZone tz = TimeZone.getTimeZone("Europe/Istanbul");
dateFormat.setTimeZone(tz);

String tar1 = dateFormat.format(calendar1.getTime());
String tar2 = dateFormat.format(calendar2.getTime());

c.add(Restrictions.between("islemZamani", tar1, tar2));