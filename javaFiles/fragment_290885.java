Calendar articleCal = Calendar.getInstance();
articleCal.setTime(articleDate);
//check for past 7 days
Calendar check = Calendar.getInstance();
check.add(Calendar.DATE, -7);
if(articleCal.after(check)) 
    sortForSevenDays.add(article);