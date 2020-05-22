package com.jam.DB;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class Database {

private static Database dbIsntance;
private static PoolDataSource pds;

private Database() {
    // private constructor //
}

public static Database getInstance() {
    if (dbIsntance == null) {
        dbIsntance = new Database();
    }
    return dbIsntance;
}

public PoolDataSource GetPoolSource() {

    if (pds == null) {
        pds = PoolDataSourceFactory.getPoolDataSource();

        try {

            pds.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
            pds.setURL("jdbc:oracle:thin:@//localhost:1521/xe");
            pds.setUser("system");
            pds.setPassword("xxxx");
            pds.setMaxStatements(15);
            return pds;

        } catch (Exception e) {

        }
        return pds;
    }

    return pds;

  }
}