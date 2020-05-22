Date date1 = null;
try {
    date1 = dateformat.parse(sdate1);
} catch (ParseException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
if (date1 != null) {
    // it was parsed successfully
    .. do something with it
}