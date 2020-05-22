String mDate = getFormattedDate(e.getString("JSON OBJECT"));

    private String getFormattedDate(String stringDate) throws JSONException {
    String strDate = stringDate.replace("/Date(", "").replace(")/", "");

    strDate = strDate.substring(0, strDate.indexOf("+"));
    Long longDate = Long.parseLong(strDate, 10);
    Date mDate = new Date(longDate);

    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
    String formattedDate = sdf.format(mDate);

    return formattedDate;
}