DateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmss");

String[] fileNameDetails = ("Gadget1-010912000000-020912235959").split("-");

/*Catch All non digit characters and removes it. If non exists maintains original string*/
String date = fileNameDetails[1].replaceAll("[^0-9]", "");

try{
    dateFormat.parse(fileNameDetails[1]);
}catch (ParseException e) {
}