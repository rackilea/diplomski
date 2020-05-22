public static void main(String[] args) throws ParseException {
     String dateStr="2014-04-05";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cal.setTime(sdf.parse(dateStr));
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));  
        System.out.println(sdf.format(cal.getTime())); 

}