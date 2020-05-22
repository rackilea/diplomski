try (ResultSet rs = s.executeQuery("SELECT DateJoined FROM Members WHERE MemberID=1")) {
    rs.next();
    System.out.printf(
            "         \"raw\" value (via .toString()): %s%n", 
            rs.getTimestamp(1).toString());
    SimpleDateFormat mmddFormat = new SimpleDateFormat("MM-dd");
    System.out.printf(
            "formatted value (via SimpleDateFormat): %s%n", 
            mmddFormat.format(rs.getTimestamp(1)));
}