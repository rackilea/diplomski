String timeGMT = "2015-05-21T08:42:27.334Z";

    DateFormat f1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    DateFormat f2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");

    Date d1 = f1.parse(timeGMT);
    Date d2 = f2.parse(timeGMT);

    System.out.println(d1);
    System.out.println(d2);