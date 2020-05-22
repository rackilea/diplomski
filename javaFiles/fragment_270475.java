String input = "STATUS | webapp | 2014/05/26 15:03:13 | Starting the service...";
    String[] splitted = input.split("\\s\\|\\s");
    String dateTime = splitted[2];
    Calendar c = Calendar.getInstance();
    try {
        Date d = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dateTime);
        c.setTime(d);
        System.out.println("Year: " + c.get(Calendar.YEAR));
        System.out.println("Month: " + c.get(Calendar.MONTH));
        System.out.println("Day in month: " + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("Hour: " + c.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minute: " + c.get(Calendar.MINUTE));
        System.out.println("Second: " + c.get(Calendar.SECOND));
    }
    catch (Throwable t) {
        // test
        t.printStackTrace();
    }