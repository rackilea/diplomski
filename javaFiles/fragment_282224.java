...
ArrayList<String> recordArray = new ArrayList<String>();
do { 
        int day1 = cal.get(Calendar.DAY_OF_WEEK);
        if (day1 == Calendar.MONDAY) {
            recordArray.add(Integer.toString(cal2.get((Calendar.DAY_OF_MONTH))-1));
        }
        cal.add(Calendar.DAY_OF_YEAR, 1);
}  while (cal.get(Calendar.MONTH) == month1);
...