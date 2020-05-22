String strDate = "29/02/2017";
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
df.setLenient(false); 
Date date = df.parse(strDate);
if (date != null) {
    // Input is valid
} else {
    // Input not valid
}