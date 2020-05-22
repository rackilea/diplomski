numMonths = numDays / 30 //If numDays is an int, this will round down.
extraDays = numDays % 30

for (int i = 0; i < numMonths; i+=30){
   double cash=0;
   for (int n=1; n < 30; n++){
      int currentDay;
      currentDay= n+i;

      cash=cash+dailyMoney[currentDay];
   }
   month++;
   if(monthlyChecks == null)
      monthlyChecks = "\nCheck on month "+month+": $"+df.format(cash)+"\n";
   else 
      monthlyChecks = monthlyChecks+"\nCheck on month "+month+": $"+df.format(cash)+"\n";
   }
}

//Then at some point
Systme.out.println("Insuffiecent days for " + numMonth + 1 " months. " + 30 - extraDays " days short).")