Map<Integer, ArrayList<String>> data = new LinkedHashMap<Integer, ArrayList<String>>();

    Calendar calendar = Calendar.getInstance();
    int year_from = 2000;
    int year_to = 2010;

    for (int year = year_from; year <= year_to; year++) {
        // make sure an array list for a given year is present
        if(! data.containsKey(year)) {
            data.put(year, new ArrayList<String>());
        }

        ArrayList<String> dates = data.get(year);

        for (int month = 1; month <= 12; month++) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month-1); // since 0 = January
            int maxDaysInMonth = calendar.getActualMaximum(Calendar.DATE);

            for (int day = 1; day <= maxDaysInMonth; day++) {
                // format date in such a way, that month and days are padded with zeroes up to 2 digits
                String dateAsString = String.format("%d-%02d-%02d", year, month, day);
                dates.add(dateAsString);
            }
        }
    }

    System.out.println(data.keySet()); // list of years present
    System.out.println(data.get(2003)); // last day of Feb: 28th
    System.out.println(data.get(2004)); // last day of Feb: 29th