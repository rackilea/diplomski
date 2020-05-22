SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");

    String sdate = "2018-09-22 10:17:24.772000";
    Date dateFrom = simpleDateFormat.parse(sdate);

    System.out.println(dateFrom); // this is what you do
    System.out.println(simpleDateFormat.format(dateFrom)); // this is what you should do

    // below is from new java.time package

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
    System.out.println(LocalDateTime.parse(sdate, formatter).format(formatter));