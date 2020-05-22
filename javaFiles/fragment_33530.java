TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar cal = Calendar.getInstance();

    try {
        Date convertedDate = dateFormatGmt.parse("2015-01-29 10:05:00");
        long diffSeconds = (cal.getTimeInMillis() - convertedDate.getTime()) / 1000;
        System.out.println("convertedDate: " + convertedDate);
        System.out.println("current: " + cal.getTime());
        System.out.println("Difference in seconds: " + diffSeconds);
    }
    catch (Exception e) {
        e.printStackTrace();
    }