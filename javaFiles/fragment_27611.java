SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

Date dateInstance = dateFormat.parse("27/07/2015");
int daysSubstracted = 548;

Calendar cal = Calendar.getInstance();
cal.setTime(dateInstance);
cal.add(Calendar.DATE, -daysSubstracted);
Date dateInPast = cal.getTime();

System.out.println(dateFormat.format(dateInPast));

// Result: 25/01/2014