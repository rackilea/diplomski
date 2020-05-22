//1. assuming Abean returning date in string value.
String availableDate = Abean.getAvailableDate();

// parsing the availableDate to string to date object.
DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); // you can use your own date format here instead of 'MM/dd/yyyy'
Date choosenDate = df.parse(availableDate);

// coverting java date object to java.sql date object.
java.sql.Date sqlDate = new java.sql.Date(choosenDate.getTime());