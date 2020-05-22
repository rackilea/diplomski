SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");
SimpleDateFormat sdfOutput = new SimpleDateFormat(yyyy MM dd");
Date date_out = null;
try {
        date_out = sdfInput.parse(date);
} catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}
String myOutputtedDate = sdfOutput.format(date_out);