public static void main(String[] args) throws ParseException {
        ConcurrentSkipListMap<Date, Integer> myMap = new ConcurrentSkipListMap<Date, Integer>();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date myDate1 = cal.getTime();
        System.out.println("Date1 = "+myDate1);
        myMap.put(myDate1, 10);

        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.DATE, -4);
        Date myDate2 = cal1.getTime();
        System.out.println("Date2 = "+myDate2);
        myMap.put(myDate2, 5);

        Date myDate3 = new Date();
        System.out.println("Date 3 "+ myDate3);
        myMap.put(myDate3, 2);

        SortedMap<Date, Integer> outputMap = myMap.subMap(myDate1, true,myDate3, false);
        System.out.println("Output Map from "+myDate1 +" to "+myDate2 + "is = "+outputMap);

    }