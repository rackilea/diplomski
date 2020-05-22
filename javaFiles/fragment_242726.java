SimpleDateFormat format1=new SimpleDateFormat("dd-MMM-yy");
long followupdate4;
try {
  Date followupdate3=format1.parse(followupdate2);
  followupdate4 = followupdate3.getTime();
} catch (ParseException e) {
  followupdate4 = 0; //Whatever you want here.
}