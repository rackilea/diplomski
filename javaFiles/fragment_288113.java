String DATE_FORMAT_NOW = "yyyy-MM-dd";
 Date date = new Date();
 SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
 String stringDate = sdf.format(date );
    try {
        Date date2 = sdf.parse(stringDate);
    } catch(ParseException e){
     //Exception handling
    } catch(Exception e){
     //handle exception
    }