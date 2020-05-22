private boolean isBetween(String t1, String t2, String target){
    boolean result = false;
    try{

        Date time1 = new SimpleDateFormat("HH:mm:ss").parse(t1);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(time1);


        Date time2 = new SimpleDateFormat("HH:mm:ss").parse(t2);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(time2);


        Date d = new SimpleDateFormat("HH:mm:ss").parse(target);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(d);


        Date x = calendar3.getTime();
        if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
            result = true;
            //checkes whether the current time is between 14:49:00 and 20:11:13.

            //Toast.makeText(UserCheckout.this, "The time is between", Toast.LENGTH_SHORT).show();
        }
    }
    catch (ParseException e){
        result = false;
        Toast.makeText(UserCheckout.this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }
    return result;
}