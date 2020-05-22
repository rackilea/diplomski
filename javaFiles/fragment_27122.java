Calendar startCal = Calendar.getInstance();
int tmpYear = startCal.get(Calendar.YEAR);
int tmpMonth = startCal.get(Calendar.MONTH) + 1;
int tmpDay = startCal.get(Calendar.DAY_OF_WEEK);

System.out.println(tmpYear + "/" + tmpMonth + "/" + tmpDay);
System.out.println(startCal.getTime());
startCal.add(Calendar.DATE, 7); //used add method here
tmpYear = startCal.get(Calendar.YEAR);
tmpMonth = startCal.get(Calendar.MONTH) + 1;
tmpDay = startCal.get(Calendar.DAY_OF_WEEK);

System.out.println(tmpYear + "/" + tmpMonth + "/" + tmpDay);
System.out.println(startCal.getTime());