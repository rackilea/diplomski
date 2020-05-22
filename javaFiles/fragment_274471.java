int numberOfDays = 7;
    DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, numberOfDays);
    String toDate = dateFormat.format(cal.getTime());
    System.out.println(toDate);