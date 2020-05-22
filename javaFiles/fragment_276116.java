con.setAutoCommit(false);//Disabling auto-commit mode

ps = con.prepareStatement(REMOVE_DATA_MAP);
for (int i = 0; i < packagedServiceIdList.size(); i++) {

    ps.setString(1, partnerId);
    ps.setString(2, packagedServiceIdList.get(i));
    ps.addBatch();
    gLogger.debug("query is: " + ps.toString());
}

int[] count = ps.executeBatch();//execute the batch

con.commit();//Commit the SQL statements