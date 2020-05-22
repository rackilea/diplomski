String str = "2015-11-25T19:36:39.571+06:00";       

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    Date date = format.parse(str);

    System.out.println(date);