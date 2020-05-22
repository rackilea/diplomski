String v_date_str="Sun Mar 06 11:28:16 IST 2011";
DateFormat formatter;
formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
Date date_temp=null;
try {
        date_temp = (Date) formatter.parse(v_date_str);
    } catch (ParseException ex) {
  Logger.getLogger(Attendance_Calculation.class.getName()).log(Level.SEVERE, null, ex);
}
System.out.println("output: "+date_temp);