PreparedStatement stmt = connection.prepareStatement("INSERT INTO RECORDS (LocationId, RecId, RecValues, YearTime, HourTime) VALUES " +
                "((SELECT LocationId from Locations where Location_name = 'Mic HR1'), ?, ?, ?, ?)");
        stmt.setInt(1, recid);
        stmt.setInt(2, inputData);
        stmt.setDate(3, sqlDate);
        stmt.setTime(4, Time.valueOf(dtf.format(now)));
        stmt.executeUpdate();