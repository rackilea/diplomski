public class GetDatesOfWeek {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.AUGUST, 1); // adjust this date and see what happens
        cal.getTime();

        cal.set(1991, Calendar.DECEMBER, 11);
        //System.out.println(cal.getTime());//LINE NO : 14

        for(int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
            cal.set(Calendar.DAY_OF_WEEK, i);
            Date date = cal.getTime();
            System.out.println(sdf.format(date));
        }
    }

}