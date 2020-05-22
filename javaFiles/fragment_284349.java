Calendar c = Calendar.getInstance();
c.set(Calendar.DATE, 17);
c.set(Calendar.MONTH, 5);
c.set(Calendar.YEAR, c.get(Calendar.YEAR));
Date date=new Date(c.getTimeInMillis());
SimpleDateFormat simpleDateformatter = new SimpleDateFormat("dd/mmm/yyyy");
String convertedDate = simpleDateformatter .format(date);