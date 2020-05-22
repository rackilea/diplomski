// Initialize connection
PreparedStatement prepStmt = connection.prepareStatement(sql);

PreparedStatementHelper prepHelper = new PreparedStatementHelper(prepStmt);

// User prepHelper.setXXX(indx++, value);
// .....

try {
   Pattern pattern = Pattern.compile("\\?");
   Matcher matcher = pattern.matcher(sql);
   StringBuffer sb = new StringBuffer();
   int indx = 1;  // Parameter begin with index 1
   while (matcher.find()) {
 matcher.appendReplacement(sb, prepHelper.getParameter(indx++));
   }
   matcher.appendTail(sb);
   LOGGER.debug("Executing Query [" + sb.toString() + "] with Database[" + /*db name*/ + "] ...");
   } catch (Exception ex) {
    LOGGER.debug("Executing Query [" + sql + "] with Database[" +  /*db name*/+ "] ...");
}

/****************************************************/

package java.sql;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public class PreparedStatementHelper implements PreparedStatement {

 private PreparedStatement prepStmt;
 private String[] values;

 public PreparedStatementHelper(PreparedStatement prepStmt) throws SQLException {
  this.prepStmt = prepStmt;
  this.values = new String[this.prepStmt.getParameterMetaData().getParameterCount()];
 }

 public String getParameter(int index) {
  String value = this.values[index-1];
  return String.valueOf(value);
 }

 private void setParameter(int index, Object value) {
  String valueStr = "";
  if (value instanceof String) {
   valueStr = "'" + String.valueOf(value).replaceAll("'", "''") + "'";
  } else if (value instanceof Integer) {
   valueStr = String.valueOf(value);
  } else if (value instanceof Date || value instanceof Time || value instanceof Timestamp) {
   valueStr = "'" + String.valueOf(value) + "'";
  } else {
   valueStr = String.valueOf(value);
  }
  this.values[index-1] = valueStr;
 }

 @Override
 public ResultSet executeQuery(String sql) throws SQLException {
  return this.prepStmt.executeQuery(sql);
 }

 @Override
 public int executeUpdate(String sql) throws SQLException {
  return this.prepStmt.executeUpdate(sql);
 }

 @Override
 public void close() throws SQLException {
  this.prepStmt.close();

 }

 @Override
 public int getMaxFieldSize() throws SQLException {
  return this.prepStmt.getMaxFieldSize();
 }

 @Override
 public void setMaxFieldSize(int max) throws SQLException {
  this.prepStmt.setMaxFieldSize(max);
 }

 @Override
 public int getMaxRows() throws SQLException {
  return this.prepStmt.getMaxRows();
 }

 @Override
 public void setMaxRows(int max) throws SQLException {
  this.prepStmt.setMaxRows(max);
 }

 @Override
 public void setEscapeProcessing(boolean enable) throws SQLException {
  this.prepStmt.setEscapeProcessing(enable);
 }

 @Override
 public int getQueryTimeout() throws SQLException {
  return this.prepStmt.getQueryTimeout();
 }

 @Override
 public void setQueryTimeout(int seconds) throws SQLException {
  this.prepStmt.setQueryTimeout(seconds);
 }

 @Override
 public void cancel() throws SQLException {
  this.prepStmt.cancel();
 }

 @Override
 public SQLWarning getWarnings() throws SQLException {
  return this.prepStmt.getWarnings();
 }

 @Override
 public void clearWarnings() throws SQLException {
  this.prepStmt.clearWarnings();
 }

 @Override
 public void setCursorName(String name) throws SQLException {
  this.prepStmt.setCursorName(name);
 }

 @Override
 public boolean execute(String sql) throws SQLException {
  return this.prepStmt.execute(sql);
 }

 @Override
 public ResultSet getResultSet() throws SQLException {
  return this.prepStmt.getResultSet();
 }

 @Override
 public int getUpdateCount() throws SQLException {
  return this.prepStmt.getUpdateCount();
 }

 @Override
 public boolean getMoreResults() throws SQLException {
  return this.prepStmt.getMoreResults();
 }

 @Override
 public void setFetchDirection(int direction) throws SQLException {
  this.prepStmt.setFetchDirection(direction);
 }

 @Override
 public int getFetchDirection() throws SQLException {
  return this.prepStmt.getFetchDirection();
 }

 @Override
 public void setFetchSize(int rows) throws SQLException {
  this.prepStmt.setFetchSize(rows);
 }

 @Override
 public int getFetchSize() throws SQLException {
  return this.prepStmt.getFetchSize();
 }

 @Override
 public int getResultSetConcurrency() throws SQLException {
  return this.prepStmt.getResultSetConcurrency();
 }

 @Override
 public int getResultSetType() throws SQLException {
  return this.prepStmt.getResultSetType();
 }

 @Override
 public void addBatch(String sql) throws SQLException {
  this.prepStmt.addBatch(sql);
 }

 @Override
 public void clearBatch() throws SQLException {
  this.prepStmt.clearBatch();
 }

 @Override
 public int[] executeBatch() throws SQLException {
  return this.prepStmt.executeBatch();
 }

 @Override
 public Connection getConnection() throws SQLException {
  return this.prepStmt.getConnection();
 }

 @Override
 public boolean getMoreResults(int current) throws SQLException {
  return this.prepStmt.getMoreResults(current);
 }

 @Override
 public ResultSet getGeneratedKeys() throws SQLException {
  return this.prepStmt.getGeneratedKeys();
 }

 @Override
 public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
  return this.prepStmt.executeUpdate(sql, autoGeneratedKeys);
 }

 @Override
 public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
  return this.prepStmt.executeUpdate(sql, columnIndexes);
 }

 @Override
 public int executeUpdate(String sql, String[] columnNames) throws SQLException {
  return this.prepStmt.executeUpdate(sql, columnNames);
 }

 @Override
 public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
  return this.prepStmt.execute(sql, autoGeneratedKeys);
 }

 @Override
 public boolean execute(String sql, int[] columnIndexes) throws SQLException {
  return this.prepStmt.execute(sql, columnIndexes);
 }

 @Override
 public boolean execute(String sql, String[] columnNames) throws SQLException {
  return this.prepStmt.execute(sql, columnNames);
 }

 @Override
 public int getResultSetHoldability() throws SQLException {
  return this.prepStmt.getResultSetHoldability();
 }

 @Override
 public boolean isClosed() throws SQLException {
  return this.prepStmt.isClosed();
 }

 @Override
 public void setPoolable(boolean poolable) throws SQLException {
  this.prepStmt.setPoolable(poolable);
 }

 @Override
 public boolean isPoolable() throws SQLException {
  return this.prepStmt.isPoolable();
 }

 @Override
 public <T> T unwrap(Class<T> iface) throws SQLException {
  return this.prepStmt.unwrap(iface);
 }

 @Override
 public boolean isWrapperFor(Class<?> iface) throws SQLException {
  return this.prepStmt.isWrapperFor(iface);
 }

 @Override
 public ResultSet executeQuery() throws SQLException {
  return this.prepStmt.executeQuery();
 }

 @Override
 public int executeUpdate() throws SQLException {
  return this.prepStmt.executeUpdate();
 }

 @Override
 public void setNull(int parameterIndex, int sqlType) throws SQLException {
  this.prepStmt.setNull(parameterIndex, sqlType);
  setParameter(parameterIndex, null);
 }

 @Override
 public void setBoolean(int parameterIndex, boolean x) throws SQLException {
  this.prepStmt.setBoolean(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setByte(int parameterIndex, byte x) throws SQLException {
  this.prepStmt.setByte(parameterIndex, x);
  // TODO Add to tree set
 }

 @Override
 public void setShort(int parameterIndex, short x) throws SQLException {
  this.prepStmt.setShort(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setInt(int parameterIndex, int x) throws SQLException {
  this.prepStmt.setInt(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setLong(int parameterIndex, long x) throws SQLException {
  this.prepStmt.setLong(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setFloat(int parameterIndex, float x) throws SQLException {
  this.prepStmt.setFloat(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setDouble(int parameterIndex, double x) throws SQLException {
  this.prepStmt.setDouble(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
  this.prepStmt.setBigDecimal(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setString(int parameterIndex, String x) throws SQLException {
  this.prepStmt.setString(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setBytes(int parameterIndex, byte[] x) throws SQLException {
  this.prepStmt.setBytes(parameterIndex, x);
  // TODO Add to tree set
 }

 @Override
 public void setDate(int parameterIndex, Date x) throws SQLException {
  this.prepStmt.setDate(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setTime(int parameterIndex, Time x) throws SQLException {
  this.prepStmt.setTime(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
  this.prepStmt.setTimestamp(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
  this.prepStmt.setAsciiStream(parameterIndex, x, length);
 }

 @SuppressWarnings("deprecation")
 @Override
 public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
  this.prepStmt.setUnicodeStream(parameterIndex, x, length);
 }

 @Override
 public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
  this.prepStmt.setBinaryStream(parameterIndex, x, length);
 }

 @Override
 public void clearParameters() throws SQLException {
  this.prepStmt.clearParameters();
 }

 @Override
 public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
  this.prepStmt.setObject(parameterIndex, x, targetSqlType);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setObject(int parameterIndex, Object x) throws SQLException {
  this.prepStmt.setObject(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public boolean execute() throws SQLException {
  return this.prepStmt.execute();
 }

 @Override
 public void addBatch() throws SQLException {
  this.prepStmt.addBatch();
 }

 @Override
 public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
  this.prepStmt.setCharacterStream(parameterIndex, reader, length);
 }

 @Override
 public void setRef(int parameterIndex, Ref x) throws SQLException {
  this.prepStmt.setRef(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setBlob(int parameterIndex, Blob x) throws SQLException {
  this.prepStmt.setBlob(parameterIndex, x);
 }

 @Override
 public void setClob(int parameterIndex, Clob x) throws SQLException {
  this.prepStmt.setClob(parameterIndex, x);
 }

 @Override
 public void setArray(int parameterIndex, Array x) throws SQLException {
  this.prepStmt.setArray(parameterIndex, x);
  // TODO Add to tree set
 }

 @Override
 public ResultSetMetaData getMetaData() throws SQLException {
  return this.prepStmt.getMetaData();
 }

 @Override
 public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
  this.prepStmt.setDate(parameterIndex, x, cal);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
  this.prepStmt.setTime(parameterIndex, x, cal);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
  this.prepStmt.setTimestamp(parameterIndex, x, cal);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
  this.prepStmt.setNull(parameterIndex, sqlType, typeName);
  setParameter(parameterIndex, null);
 }

 @Override
 public void setURL(int parameterIndex, URL x) throws SQLException {
  this.prepStmt.setURL(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public ParameterMetaData getParameterMetaData() throws SQLException {
  return this.prepStmt.getParameterMetaData();
 }

 @Override
 public void setRowId(int parameterIndex, RowId x) throws SQLException {
  this.prepStmt.setRowId(parameterIndex, x);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setNString(int parameterIndex, String value) throws SQLException {
  this.prepStmt.setNString(parameterIndex, value);
  setParameter(parameterIndex, value);
 }

 @Override
 public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
  this.prepStmt.setNCharacterStream(parameterIndex, value, length);
 }

 @Override
 public void setNClob(int parameterIndex, NClob value) throws SQLException {
  this.prepStmt.setNClob(parameterIndex, value);
 }

 @Override
 public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
  this.prepStmt.setClob(parameterIndex, reader, length);
 }

 @Override
 public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
  this.prepStmt.setBlob(parameterIndex, inputStream, length);
 }

 @Override
 public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
  this.prepStmt.setNClob(parameterIndex, reader, length);
 }

 @Override
 public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
  this.prepStmt.setSQLXML(parameterIndex, xmlObject);
  setParameter(parameterIndex, xmlObject);
 }

 @Override
 public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
  this.prepStmt.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
  setParameter(parameterIndex, x);
 }

 @Override
 public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
  this.prepStmt.setAsciiStream(parameterIndex, x, length);
 }

 @Override
 public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
  this.prepStmt.setBinaryStream(parameterIndex, x, length);
 }

 @Override
 public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
  this.prepStmt.setCharacterStream(parameterIndex, reader, length);
 }

 @Override
 public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
  this.prepStmt.setAsciiStream(parameterIndex, x);
  // TODO Add to tree set
 }

 @Override
 public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
  this.prepStmt.setBinaryStream(parameterIndex, x);
 }

 @Override
 public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
  this.prepStmt.setCharacterStream(parameterIndex, reader);
 }

 @Override
 public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
  this.prepStmt.setNCharacterStream(parameterIndex, value);
 }

 @Override
 public void setClob(int parameterIndex, Reader reader) throws SQLException {
  this.prepStmt.setClob(parameterIndex, reader);
  // TODO Add to tree set
 }

 @Override
 public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
  this.prepStmt.setBlob(parameterIndex, inputStream);
 }

 @Override
 public void setNClob(int parameterIndex, Reader reader) throws SQLException {
  this.prepStmt.setNClob(parameterIndex, reader);
 }

}