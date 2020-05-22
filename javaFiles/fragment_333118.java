Date today = new Date();
Calendar cal = new GregorianCalendar();
cal.setTime(today);
cal.add(Calendar.DAY_OF_MONTH, -30);
Date today30 = cal.getTime();
cal.add(Calendar.DAY_OF_MONTH, -60);
Date today60 = cal.getTime();
cal.add(Calendar.DAY_OF_MONTH, -90);
Date today90 = cal.getTime();