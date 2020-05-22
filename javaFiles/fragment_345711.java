public static void main(String[] args) {

    List<String> strings =
        Arrays.asList("2013-7-13 \n 12 hour(s) 23 minute(s)",
            "2013-7-10 \n 12 hour(s) 23 minute(s)");

    Collections.sort(strings, new Comparator<String>() {

      @Override
      public int compare(String o1, String o2) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date date1;
        Date date2;
        try {
          date1 = format.parse(o1.split(" ")[0]);
          date2 = format.parse(o2.split(" ")[0]);
        } catch (ParseException e) {
          throw new IllegalArgumentException("Could not parse date!", e);
        }

        return date1.compareTo(date2);
      }
    });


    System.out.println(strings);

  }