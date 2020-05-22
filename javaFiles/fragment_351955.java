SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("EEEE, MMMM d, yyyy h:mm a");
SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEEE, d MMMM, yyyy H:mm");
Date result = null;
while( logic statement){
    try{
        result = simpleDateFormat1.parse(dateAsString);
    }catch (ParseException e){
        result = simpleDateFormat2.parse(dateAsString);
    }
//do whatever want with the result.
}