List<String> dates = Arrays.asList(new String[]{
        "Thursday (13:00 to 14:30)",
        "Saturday (14:20 to 18:10)",
        "Monday (09:00 to 14:25)",
        "Saturday (11:00 to 12:30)"
});
Comparator<String> dateComparator = new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        try{
            SimpleDateFormat format = new SimpleDateFormat("EEE");
            Date d1 = format.parse(s1);
            Date d2 = format.parse(s2);
            if(d1.equals(d2)){
                return s1.substring(s1.indexOf(" ") + 1).compareTo(s2.substring(s2.indexOf(" ") + 1));
            }else{
                Calendar cal1 = Calendar.getInstance();
                Calendar cal2 = Calendar.getInstance();
                cal1.setTime(d1);
                cal2.setTime(d2);
                return cal1.get(Calendar.DAY_OF_WEEK) - cal2.get(Calendar.DAY_OF_WEEK);
            }
        }catch(ParseException pe){
            throw new RuntimeException(pe);
        }
    }
};
Collections.sort(dates, dateComparator);
System.out.println(dates);