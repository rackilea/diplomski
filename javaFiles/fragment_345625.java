String text = "2011-10-02 18:48:05";
    String text2 = "2011-10-02 18:50:05";
    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    DateTime oldDate = formatter.parseDateTime(text);
    DateTime newDate = formatter.parseDateTime(text2);
    System.out.println(oldDate);
    System.out.println(newDate);
    Interval interval = new Interval(oldDate, newDate);
    System.out.println(interval);