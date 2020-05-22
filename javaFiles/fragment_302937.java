String dateString= "11/25/2018";

    int first = dateString.indexOf("/");

    String dayWithYear = dateString.substring(first + 1);
    int last = dayWithYear.indexOf("/");

    String monthString = dateString.substring(0, first);
    String dayString = dayWithYear.substring(0, last);
    String yearString = dayWithYear.substring(last + 1);

    System.out.println(monthString);
    System.out.println(dayString);
    System.out.println(yearString);