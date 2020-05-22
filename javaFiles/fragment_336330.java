Working Code:

public int monthsBetweenDates(Date startDate, Date endDate){

        Calendar start = Calendar.getInstance();
        start.setTime(startDate);

        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

          int monthsBetween = 0;
            int dateDiff = end.get(Calendar.DAY_OF_MONTH)-start.get(Calendar.DAY_OF_MONTH);      

if(dateDiff<0) {
                int borrrow = end.getActualMaximum(Calendar.DAY_OF_MONTH);           
                 dateDiff = (end.get(Calendar.DAY_OF_MONTH)+borrrow)-start.get(Calendar.DAY_OF_MONTH);
                 monthsBetween--;

if(dateDiff>0) {
                     monthsBetween++;
                 }
            }
            else {
                monthsBetween++;
            }      
            monthsBetween += end.get(Calendar.MONTH)-start.get(Calendar.MONTH);      
            monthsBetween  += (end.get(Calendar.YEAR)-start.get(Calendar.YEAR))*12;      
            return monthsBetween;
     }