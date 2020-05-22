for (ParseObject requestObject: requestsArrayList) {
SimpleDateFormat sdf2 = new SimpleDateFormat("E MMM dd");
String date = null;
try {
    date = sdf.format(requestObject.getDate(ParseConstantsUtil.REQUEST_DATE_REQUESTED));
    log.info(String.valueOf(date));
} catch (java.text.ParseException e1) {
    e1.printStackTrace();
}
requestObject.add(ParseConstantsUtil.REQUEST_DATE_REQUESTED, date);
}