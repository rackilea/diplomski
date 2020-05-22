conn.setAutoCommit(false);

headerProc = conn.prepareCall("headerProc...");
headerProc.setString(...);
headerProc.execute();

detailProc = conn.prepareCall("detailProc...");

for(Fault fault : faultList) {
    detailProc.setString(...);
    detailProc.execute();
    detailProc.clearParameters();
}

conn.commit();