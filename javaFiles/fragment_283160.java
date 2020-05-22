SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S");
String reformattedDate = "";
Date date_out = null;
try {
        date_out = sdf.parse(date);
} catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}
sdf.applyPattern("yyyy MM dd");
if (date_out != null)
{
    reformattedDate = sdf.format(date_out);
}