/**
 * Implementors of this interface should only convert current row to byte array and return it.
 * 
 * @author yura
 */
public interface RowToByteArrayConverter {
    byte[] rowToByteArray(ResultSet resultSet);
}

public class ResultSetAsInputStream extends InputStream {

    private final RowToByteArrayConverter converter;
    private final PreparedStatement statement;
    private final ResultSet resultSet;

    private byte[] buffer;
    private int position;

    public ResultSetAsInputStream(final RowToByteArrayConverter converter, final Connection connection, final String sql, final Object... parameters) throws SQLException {
        this.converter = converter;
        statement = createStatement(connection, sql, parameters);
        resultSet = statement.executeQuery();
    }

    private static PreparedStatement createStatement(final Connection connection, final String sql, final Object[] parameters) {
        // PreparedStatement should be created here from passed connection, sql and parameters
        return null;
    }

    @Override
    public int read() throws IOException {
        try {
            if(buffer == null) {
                // first call of read method
                if(!resultSet.next()) {
                    return -1; // no rows - empty input stream
                } else {
                    buffer = converter.rowToByteArray(resultSet);
                    position = 0;
                    return buffer[position++] & (0xff);
                }
            } else {
                // not first call of read method
                if(position < buffer.length) {
                    // buffer already has some data in, which hasn't been read yet - returning it
                    return buffer[position++] & (0xff);
                } else {
                    // all data from buffer was read - checking whether there is next row and re-filling buffer
                    if(!resultSet.next()) {
                        return -1; // the buffer was read to the end and there is no rows - end of input stream
                    } else {
                        // there is next row - converting it to byte array and re-filling buffer
                        buffer = converter.rowToByteArray(resultSet);
                        position = 0;
                        return buffer[position++] & (0xff);
                    }
                }
            }
        } catch(final SQLException ex) {
            throw new IOException(ex);
        }
    }



    @Override
    public void close() throws IOException {
        try {
            statement.close();
        } catch(final SQLException ex) {
            throw new IOException(ex);
        }
    }
}