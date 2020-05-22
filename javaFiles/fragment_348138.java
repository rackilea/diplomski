public void setObject(int parameterIndex, Object parameterObj) throws SQLException {
    synchronized (checkClosed().getConnectionMutex()) {
        if (parameterObj == null) {
            setNull(parameterIndex, java.sql.Types.OTHER);
        } else {
            if (parameterObj instanceof Byte) {
                setInt(parameterIndex, ((Byte) parameterObj).intValue());
            } else if (parameterObj instanceof String) {
                setString(parameterIndex, (String) parameterObj);
            } else if (parameterObj instanceof BigDecimal) {
                setBigDecimal(parameterIndex, (BigDecimal) parameterObj);
            } else if (parameterObj instanceof Short) {
                setShort(parameterIndex, ((Short) parameterObj).shortValue());
            } else if (parameterObj instanceof Integer) {
                setInt(parameterIndex, ((Integer) parameterObj).intValue());
            } else if (parameterObj instanceof Long) {
                setLong(parameterIndex, ((Long) parameterObj).longValue());
            } else if (parameterObj instanceof Float) {
                setFloat(parameterIndex, ((Float) parameterObj).floatValue());
            } else if (parameterObj instanceof Double) {
                setDouble(parameterIndex, ((Double) parameterObj).doubleValue());
            } else if (parameterObj instanceof byte[]) {
                setBytes(parameterIndex, (byte[]) parameterObj);
            } else if (parameterObj instanceof java.sql.Date) {
                setDate(parameterIndex, (java.sql.Date) parameterObj);
            } else if (parameterObj instanceof Time) {
                setTime(parameterIndex, (Time) parameterObj);
            } else if (parameterObj instanceof Timestamp) {
                setTimestamp(parameterIndex, (Timestamp) parameterObj);
            } else if (parameterObj instanceof Boolean) {
                setBoolean(parameterIndex, ((Boolean) parameterObj).booleanValue());
            } else if (parameterObj instanceof InputStream) {
                setBinaryStream(parameterIndex, (InputStream) parameterObj, -1);
            } else if (parameterObj instanceof java.sql.Blob) {
                setBlob(parameterIndex, (java.sql.Blob) parameterObj);
            } else if (parameterObj instanceof java.sql.Clob) {
                setClob(parameterIndex, (java.sql.Clob) parameterObj);
            } else if (this.connection.getTreatUtilDateAsTimestamp() && parameterObj instanceof java.util.Date) {
                setTimestamp(parameterIndex, new Timestamp(((java.util.Date) parameterObj).getTime()));
            } else if (parameterObj instanceof BigInteger) {
                setString(parameterIndex, parameterObj.toString());
            } else {
                setSerializableObject(parameterIndex, parameterObj);
            }
        }
    }
}