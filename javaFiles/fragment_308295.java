final String str = "14:21:16";
final Timestamp timestamp =
    Timestamp.valueOf(
        new SimpleDateFormat("yyyy-MM-dd ")
        .format(new Date()) // get the current date as String
        .concat(str)        // and append the time
    );
System.out.println(timestamp);