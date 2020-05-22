String fs = "01/02/2012";
  String ts = "01/03/2013";
  DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
  sdf.setLenient(false);
  Date fdate = sdf.parse(fs);
  Date tdate = sdf.parse(ts);
  if (fdate.before(tdate) || f.date.equals(tdate)) {
         //process;      
  }