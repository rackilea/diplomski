Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        cal.clear();
        cal.set(Calendar.YEAR, year);

        for (int currentMonth = month; currentMonth < 12; currentMonth++) {

            cal.set(Calendar.MONTH, currentMonth);

            //first day :
            cal.set(Calendar.DAY_OF_MONTH, 1);
            Date firstDay = cal.getTime();
            System.out.println("firstDay=" + firstDay);

            //last day
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            Date lastDay = cal.getTime();
            System.out.println("lastDay=" + lastDay);
        }