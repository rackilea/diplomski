public static void main(String...args)  {

        GregorianCalendar startDate = 
            new GregorianCalendar(2014, GregorianCalendar.JUNE, 26);
        GregorianCalendar endDate = 
            new GregorianCalendar(2014, GregorianCalendar.OCTOBER, 9);

        while (startDate.get(Calendar.MONTH) <= endDate.get(Calendar.MONTH)) {
            System.out.println(startDate.getActualMaximum(Calendar.DAY_OF_MONTH));  
            startDate.add(Calendar.MONTH, 1);
        }
    }