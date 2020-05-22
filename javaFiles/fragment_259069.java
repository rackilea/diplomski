try {
    Calendar now = Calendar.getInstance();
    DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); 
    String nowDate1 = formatter.format(now.getTime());
    Date nowDate = formatter.parse(nowDate1);
}
catch (Exception e) {
    e.printStackTrace();
}