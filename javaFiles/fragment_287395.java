Date start = new Date(2010, 10, 13);
Date end   = new Date(2010, 10, 18);

long diffInMillis = end.getTime() - start.getTime();

long diffInDays  = diffInMillis/1000/86400;
long diffInHours = (diffInMillis/1000 - 86400*diffInDays) / 3600;
long diffInMins  = (diffInMillis/1000 - 86400*diffInDays - 3600*diffInHours) / 60;
long diffInSecs  = (diffInMillis/1000 - 86400*diffInDays - 3600*diffInHours - 60*diffInMins);