List<List<String>> getNumberOfWeeks(int year, int month) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        List<List<String>> weekdates = new ArrayList<List<String>>();
        List<String> dates;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, 1);
        while (c.get(Calendar.MONTH) == month) {
                dates = new ArrayList<String>();
              while (c.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
                c.add(Calendar.DAY_OF_MONTH, -1);
              }
              dates.add(format.format(c.getTime()));
              c.add(Calendar.DAY_OF_MONTH, 6);
              dates.add(format.format(c.getTime()));
              weekdates.add(dates);
              c.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println(weekdates);
        return weekdates;
      }