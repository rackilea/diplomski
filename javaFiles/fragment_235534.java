Calendar rightNow = Calendar.getInstance();

// offset to add since we're not UTC
long offset = rightNow.get(Calendar.ZONE_OFFSET) +
    rightNow.get(Calendar.DST_OFFSET);
long sinceMidnight = (rightNow.getTimeInMillis() + offset) %
    (24 * 60 * 60 * 1000);

System.out.println(sinceMidnight + " milliseconds since midnight");