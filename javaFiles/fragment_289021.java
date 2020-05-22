Date date = PrimeUtil.formatStringToTime("2017-02","yyyy-MM");
System.out.println(date);
Calendar c = Calendar.getInstance();
c.setTime(date);
c.set(Calendar.DAY_OF_MONTH,c.getActualMaximum(c.DAY_OF_MONTH));
System.out.println(c.getTime());