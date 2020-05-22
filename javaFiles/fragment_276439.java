LocalDate date = LocalDate.now();
        int month = date.getMonthValue();

        for (int currentMonth = month; currentMonth <= 12; currentMonth++) {
            date = date.withMonth(currentMonth);

            //start of month :
            LocalDate firstDay = date.withDayOfMonth(1);
            System.out.println("firstDay=" + firstDay);

            //end of month
            LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
            System.out.println("lastDay=" + lastDay);
        }