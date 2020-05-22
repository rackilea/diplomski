Calendar morn = Calendar.getInstance();
morn.set(Calendar.HOUR_OF_DAY, 4);
morn.set(Calendar.MINUTE, 0);
morn.set(Calendar.SECOND, 0);
morn.set(Calendar.AM_PM, Calendar.PM);

System.out.println(someDateFormat.format(morn.getTime()));
// current hour

morn = Calendar.getInstance();
morn.set(Calendar.HOUR, 4);
morn.set(Calendar.MINUTE, 0);
morn.set(Calendar.SECOND, 0);
morn.set(Calendar.AM_PM, Calendar.PM);

System.out.println(someDateFormat.format(morn.getTime()));
// correct hour