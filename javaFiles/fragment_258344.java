SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
Date before = sdf.parse("07/05/2012 08:00");
Date after = sdf.parse("07/05/2012 08:30");
Date toCheck = sdf.parse("07/05/2012 08:15");
//is toCheck between the two?
boolean isAvailable = (before.getTime() < toCheck.getTime()) && after.getTime() > toCheck.getTime();