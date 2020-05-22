JSONObject jsonObj = new JSONObject(jsonStr);
SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd");

Date date = null;
try {
  date = sourceFormat.parse(jsonObj.getString("date"));
} 
catch (ParseException e) {
  e.printStackTrace();
}