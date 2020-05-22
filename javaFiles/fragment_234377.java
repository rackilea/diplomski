protected Fault getFault(Integer buno, Integer faultCode,
        GregorianCalendar downloadTime, IFilterEncoder filter, FaultType faultType, boolean verbose) {
    Fault fault = new Fault(faultCode, 0);
    try {
        // We must be inside a transaction for cursors to work.
        conn.setAutoCommit(false);
        // Procedure call: getFault(integer, text, timestamp, integer)
        proc = conn.prepareCall("{ ? = call getfaultCount(?, ?, ?, ?, ?) }");
        proc.registerOutParameter(1, Types.OTHER);
        proc.setInt(2, buno);
        proc.setInt(3, faultCode);
        Timestamp ts = new Timestamp(downloadTime.getTimeInMillis());
        cal.setTimeZone(downloadTime.getTimeZone());
        proc.setTimestamp(4, ts, cal);
        proc.setInt(5, filter.getEncodedFilter());
        proc.setString(6, faultType.toString());
        proc.execute();
        if(verbose) {
            log.logInfo(this.getClass().getName(), "SQL: " + proc.toString());
        }
        results = (ResultSet) proc.getObject(1);
        while (results.next()) {
            //Do something with the results here
        }
    } catch (SQLException e) {
        //Log or handle exceptions here
    }
    return fault;
}