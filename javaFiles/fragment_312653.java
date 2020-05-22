callableStatement = connectionHelper1.getMyConnection().prepareCall("{call SpSelectTrackVehiclePath(?, ?, ?,?)}");
callableStatement.setString(1, IMEArrayAdapter.getItem(listView.getCheckedItemPosition()));//IMEArrayAdapter in below will explain,gives the first field of SP.

callableStatement.setTimestamp(2, new java.sql.Timestamp(startCalendar.getTimeInMillis()));
callableStatement.setTimestamp(3, new java.sql.Timestamp(finalCalendar.getTimeInMillis()));

callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);

ResultSet resultSet = callableStatement.executeQuery();