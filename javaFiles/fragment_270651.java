Timestamp controlTime = Timestamp.valueOf("2014-08-15 03:52:00");
Calendar cal = Calendar.getInstance();
cal.setTime(controlTime);
cal.add(Calendar.DAY_OF_MONTH, -10);
lookupTime.setTimestamp(1, new Timestamp(cal.getTimeInMillis()));
cal.setTime(controlTime);
cal.add(Calendar.DAY_OF_MONTH, 10);
lookupTime.setTimestamp(2, new Timestamp(cal.getTimeInMillis()));
try (ResultSet rs = lookupTime.executeQuery()) {
    while (rs.next()) {
        long tdiffInSeconds = (rs.getTimestamp("LOGGED_TIME").getTime() - controlTime.getTime()) / 1000;
        // other code
    }
}