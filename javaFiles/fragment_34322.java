Calendar calendar = Calendar.getInstance();
    System.out.println(calendar.getTime());
    calendar.add(Calendar.DATE, -10); // 10 days before today
    Date toDate = calendar.getTime();
      // remember now your calendar instance 10 days older than today
      // so reduce 10 more days equals to 20 days before today
    calendar.add(Calendar.DATE,-10); // another 10 days before today
    Date fromDate=calendar.getTime();
    System.out.println("from date: "+fromDate);
    System.out.println("to date: "+toDate);