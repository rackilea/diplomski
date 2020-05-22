public static void main (String[] args) throws java.lang.Exception
    {
         SimpleDateFormat month_date = new SimpleDateFormat("MMM-yyyy");
         Calendar calendar = Calendar.getInstance();
         calendar.add(Calendar.MONTH, -1);

         String month_name = month_date.format(calendar.getTime());
         System.out.println("month_name : "+month_name);
   }