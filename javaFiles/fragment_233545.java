public class MainClass{


    public static void main(String[] args) {
        ArrayList<Period> list = splitPeriods(15); 

    }

private static ArrayList<Period>  splitPeriods(int days){
        ArrayList<Period> list = new ArrayList<>();
        java.sql.Timestamp start = new Timestamp(110, 2, 1, 00, 00, 00, 00); //start 1 March 2010
        java.sql.Timestamp end = new Timestamp(  110, 3, 30, 00, 00, 00, 00); //end 30 April 2010
        Timestamp current = start;
        Period period;
        while(current.before(end)){
            period = new Period();
            //new timestamp for start Period
            java.sql.Timestamp startPeriod = new Timestamp(current.getTime());
            //change current timestamp
            current.setDate((current.getDate()+days));    

            //new timestamp for end period.
            //set prev day and time 23:59:59...
            java.sql.Timestamp endPeriod = new Timestamp(current.getTime());
            endPeriod.setDate(endPeriod.getDate()-1);
            endPeriod.setHours(23);
            endPeriod.setMinutes(59);
            endPeriod.setSeconds(59);
            endPeriod.setNanos(599999999);

            //add to list
            period.setStart(startPeriod);
            period.setEnd(endPeriod);

            System.out.println(period.getStart() +"\t"+period.getEnd());

        }
        return list;
    }
}