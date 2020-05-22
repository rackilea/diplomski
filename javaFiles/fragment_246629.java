public class ListItemData {
    ListItemData(ResultSet rs) throws SQLException {
        name = rs.getString(1);
        reservationDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S").parse(rs.getTimestamp(2).toString());
        preferredArea = rs.getString(3);
        guests = rs.getString(4);
        notes = rs.getString(5);
        noSms = rs.getInt(6) == 1;
    }

    String name;
    Date reservationDate;
    String preferredArea;
    String guests;
    String notes;
    boolean noSms;
}