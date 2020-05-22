String[] yourString = "2015, 2, 31, 17, 0, 1".split(",");

Calendar c = new GregorianCalendar();
c.set(Calendar.YEAR, Integer.valueOf(yourString[0]));
c.set(Calendar.MONTH, Integer.valueOf(yourString[1]));
c.set(Calendar.DAY_OF_MONTH, Integer.valueOf(yourString[2]));
c.set(Calendar.HOUR_OF_DAY, Integer.valueOf(yourString[3]));
c.set(Calendar.MINUTE, Integer.valueOf(yourString[4]));
c.set(Calendar.SECOND, Integer.valueOf(yourString[5]));