public class RowHandler {
    private static final RowProcessor ROW_PROCESSOR = new BasicRowProcessor();
    private JsonLOutputWriter writer;

    public RowHandler(JsonLOutputWriter writer) {
        this.writer = writer;
    }

    int handle(ResultSet rs) throws SQLException {
        AtomicInteger counter = new AtomicInteger();
        while (rs.next()) {
            writer.writeRow(this.handleRow(rs));
            counter.getAndIncrement();
        }
        return counter.intValue();
    }

    protected Map<String, Object> handleRow(ResultSet rs) throws SQLException {
        return this.ROW_PROCESSOR.toMap(rs);
    }

}