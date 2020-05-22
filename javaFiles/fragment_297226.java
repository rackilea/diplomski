Calendar cal = new GregorianCalendar();
cal.clear();
cal.set(Calendar.YEAR, year + 2000);
cal.set(Calendar.DAY_OF_YEAR, dayNumber);
cal.add(Calendar.SECOND, numSeconds); // add handles overflow from one field to next
Date date = cal.getTime();