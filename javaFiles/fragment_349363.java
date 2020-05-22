Duration duration = new Duration(firstIn, lastDateOut); //Duration between two dates choosen by the user
int dimension=(int) ((duration.getStandardMinutes())/divideBy); //Number of abscissa points in the chart
DateTime transfert=firstIn; //First date
DateTime currentDate=transfert; // X-Axis Date
int currentCount=0; // Y-Axis LoggedUser Count

//Log data
DateTime log_DateIn;
DateTime log_DateOut;

for(int i=0;i<=dimension;i++)
{
   currentDate = transfert;
   currentCount = 0;
   transfert = transfert.plusMinutes(divideBy);

   for(Log log:old)
   {
      // We store our dates into variables, that way we avoid doing the time conversion twice
      log_DateIn = StaticMethods.toDateTime(log.getDate_in()).minusSeconds(StaticMethods.toDateTime(log.getDate_in()).getSecondOfMinute());

      log_DateOut = StaticMethods.toDateTime(log.getDate_out()).minusSeconds(StaticMethods.toDateTime(log.getDate_out()).getSecondOfMinute());

      // Since we made the list ordered by DateOut, we are sure that if the stored DateOut is greater than transfert we can't find another user, that way we can break the for without parsing each log
      if(log_DateOut.isAfter(transfert))
         break;

      // Now we can do checks to see if we need to increase the count
      // We just check if the DateIn is between the currentDate and currentDate + divideBy (transfert)
      if(log_DateIn.isAfter(currentDate) && log_DateIn.isBefore(transfert))
         currentCount++;
      // Same thing for DateOut
      else if(log_DateOut.isAfter(currentDate) && log_DateOut.isBefore(transfert))
         currentCount++;
      // Now we need both cases
      else if(log_DateIn.isBefore(currentDate) && log_DateOut.isAfter(transfert))
         currentCount++;
      // Equalities
      else if(log_DateIn.equals(currentDate) || log_DateIn.equals(transfert) || log_DateOut.equals(currentDate) || log_DateOut.equals(transfert))
         currentCount++;
   }

   GraphData nw = new GraphData(currentDate, currentCount);
}