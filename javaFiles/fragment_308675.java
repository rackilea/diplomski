Calendar tzCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
ResultSet rs = ...;
while (rs.next()) {
    Date dateValue = rs.getDate("DateColumn", tzCal);
    // Other fields and calculations
}