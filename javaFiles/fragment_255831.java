public class Test {             

    public static void main(String[] args) { 

        GregorianCalendar c = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        c.set(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.SUNDAY);
        System.out.println("End date of this week = "+sdf.format(c.getTime()));
        for(int i = 1 ; i <=5 ; i++){
            c.set(GregorianCalendar.WEEK_OF_YEAR, c.get(GregorianCalendar.WEEK_OF_YEAR)-1);
            System.out.println("End date of "+i+" week ago = "+sdf.format(c.getTime()));
        }          
    }
}