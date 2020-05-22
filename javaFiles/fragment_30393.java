public static void main(String[] args) {
       SimpleDateFormat df = new SimpleDateFormat("S");
       Date d = new Date();
       System.out.println(df.format(d));
       Calendar c = Calendar.getInstance();
       c.set(Calendar.MILLISECOND, 0);
       d.setTime(c.getTimeInMillis());
       System.out.println(df.format(d));

}