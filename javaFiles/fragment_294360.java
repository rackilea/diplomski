try{

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date date1 = sdf.parse("yourFirstDate"); //or just "new Date();" if you want the current date
    Date date2 = sdf.parse("yourSecondDate"); 

    if(date1.after(date2)){
       Log.d("Date1 is after Date2");
    } else if(date1.before(date2)){
       Log.d("Date1 is before Date2");
    } else {
       Log.d("Date1 is equal Date2");
    }

}catch(ParseException e){
     e.printStackTrace();
}