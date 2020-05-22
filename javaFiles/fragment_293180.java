public static void main(String[] args) {
    List<String> li = new ArrayList<String>();
    li.add("1"); 
    li.add("2"); 
    li.add("3"); 
    li.add("4"); 
    li.add("5"); 
    Map<Date, List<String>> Hash = new TreeMap<>(new Comparator<Date>() {
        @Override
        public int compare(Date o1, Date o2) {
            Calendar first = Calendar.getInstance();
            first.setTime(o1);
            Calendar second = Calendar.getInstance();
            second.setTime(o2);
            int month1 = first.get(Calendar.MONTH);
            int month2 = second.get(Calendar.MONTH);
            if (month1 != month2) {
                return month2 - month1;
            } else {
                int day1 = first.get(Calendar.DATE);
                int day2 = second.get(Calendar.DATE);
                return day2 - day1;
            }
        }
    });

    Date D1 = funx("1999-04-04");
    Date D2 = funx("1999-01-03");
    Date D3 = funx("1999-03-03");
    Date D4 = funx("1999-08-05");
    Date D5 = funx("1999-12-25");

    Hash.put(D1, li);
    Hash.put(D2, li);
    Hash.put(D3, li);
    Hash.put(D4, li);
    Hash.put(D5, li);

    for (Map.Entry<Date, List<String>> entry: Hash.entrySet()) {
        System.out.println( entry.getKey() +" "+entry.getValue());
    }        
}

public static Date funx(String S) {

    String DateStr = S;
    Date d = null;
    try {
        d = new SimpleDateFormat("yyyy-MM-dd").parse(DateStr);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    java.sql.Date d1 = new java.sql.Date(d.getTime());

    return d1;
}