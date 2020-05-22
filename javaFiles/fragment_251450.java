public class CalendarBigIntType extends org.hibernate.type.CalendarType {
    public Object get(ResultSet rs, String name) {
        return cal = new GregorianCalendar(rs.getLong(name));
    }
    public void set(PreparedStatement stmt, Object value, int index) {
        stmt.setParameter(index, ((Calendar) value).getTime());
    }
}