Calendar cStart = Calendar.getInstance();

Calendar cMon = null;
Calendar cTue = null;
Calendar cWed = null;
Calendar cThu = null;
Calendar cFri = null;
Calendar cSat = null;
Calendar cSun = null;

cMon = (Calendar) cStart.clone();
cStart.add(Calendar.DAY_OF_MONTH, 1);
cTue = (Calendar) cStart.clone();
cStart.add(Calendar.DAY_OF_MONTH, 1);
cWed = (Calendar) cStart.clone();
cStart.add(Calendar.DAY_OF_MONTH, 1);
cThu = (Calendar) cStart.clone();
cStart.add(Calendar.DAY_OF_MONTH, 1);
cFri = (Calendar) cStart.clone();
cStart.add(Calendar.DAY_OF_MONTH, 1);
cSat = (Calendar) cStart.clone();
cStart.add(Calendar.DAY_OF_MONTH, 1);
cSun = (Calendar) cStart.clone();

System.out.println(cMon.getTime());
System.out.println(cTue.getTime());
System.out.println(cWed.getTime());
System.out.println(cThu.getTime());
System.out.println(cFri.getTime());
System.out.println(cSat.getTime());
System.out.println(cSun.getTime());