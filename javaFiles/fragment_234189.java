package com.text.service.dao;

public class DataDaoImpl extends SomeOtherDaoWhereDataSourceIsDefined {
    private String gpsDataAllStopsSql;
    private String gpsDataSql;

    public String getGpsDataAllStopsSql() {
        return gpsDataAllStopsSql;
    }

    public void setGpsDataAllStopsSql(String gpsDataAllStopsSql) {
        this.gpsDataAllStopsSql = gpsDataAllStopsSql;
    }

    public String getGpsDataSql() {
        return gpsDataSql;
    }

    public void setGpsDataSql(String gpsDataSql) {
        this.gpsDataSql = gpsDataSql;
    }
}