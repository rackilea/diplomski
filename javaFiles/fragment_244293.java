SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dd = "2018-01-29 12:35:00";




    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
        date = sdf.parse(dd);
    }catch (Exception e){

    }
    sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
  //        System.out.println(sdf.format(date));
    Log.e("@@@Date: ",String.valueOf(sdf.format(date)));