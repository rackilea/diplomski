public Date1(int d, int m, int y) {

        this.day = d;
        this.month = m;
        this.year = y;
    }



  public void addDay() {
    month--;
    Calendar m = Calendar.getInstance();
    m.set(year, month, day);
    m.add(day, 5);

    java.sql.Date d = new java.sql.Date(m.getTimeInMillis());
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    System.out.println(" date is  " + df.format(d));

}