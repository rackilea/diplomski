String dateString= "05-02-2018";
DateFormat dateFormater = new SimpleDateFormat("dd-MM-yyyy"); 
Date aux;
try {
    aux = dateFormater.parse(dateString);
} catch (ParseException e) {
    e.printStackTrace();
}