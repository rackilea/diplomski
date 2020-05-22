SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
  Date date;

 @SuppressLint("SimpleDateFormat") 
 public static Date getDate(String string){

         date = new Date();

         try {
                date = format.parse(string);
        }     catch (ParseException e) {
                e.printStackTrace();
        }

       return date; 
  }