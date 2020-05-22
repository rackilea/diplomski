Query q = session.createQuery("from GpsData " +
                              "where mobileUnitId = '2090818044' " +
                              "and gpsDate in " +
                              "(select gpsDate from GpsData " +
                              "where mobileUnitId = '2090818044' " +
                              "ORDER BY gpsDate DESC LIMIT 1) " +
                              "and gpsStatus='true'");