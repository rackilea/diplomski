Calendar calendar = Calendar.getInstance();         
calendar.add(Calendar.MONTH, 1);
calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
Date nextMonthFirstDay = calendar.getTime();
calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
Date nextMonthLastDay = calendar.getTime();