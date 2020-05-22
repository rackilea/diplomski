Date purchasedDate = new Date ();
//multiply the timestampt with 1000 as java expects the time in milliseconds
purchasedDate.setTime((long)purchasedtime*1000);

Date currentDate = new Date ();
currentDate .setTime((long)currentTime*1000);

//To calculate the days difference between two dates 
int diffInDays = (int)( (currentDate.getTime() - purchasedDate.getTime()) 
                 / (1000 * 60 * 60 * 24) )