boolean autoCommit = connection.getAutoCommit();
try{
    connection.setAutoCommit(false //Turn off autoCommit
    pstatement = db_connection.prepareStatement(PDSLnPConstants.UPSERT_SQL);

    int batchLimit = 1000;

    try{
        for (Entry<Integer, LinkedHashMap<Integer, String>> entry : MAPPING.entrySet()) {
            pstatement.setInt(1, entry.getKey());
            pstatement.setString(2, entry.getValue().get(LnPConstants.CGUID_ID));
            pstatement.setString(3, entry.getValue().get(LnPConstants.PGUID_ID));
            pstatement.setString(4, entry.getValue().get(LnPConstants.SGUID_ID));
            pstatement.setString(5, entry.getValue().get(LnPConstants.UID_ID));
            pstatement.setString(6, entry.getValue().get(LnPConstants.ULOC_ID));
            pstatement.setString(7, entry.getValue().get(LnPConstants.SLOC_ID));
            pstatement.setString(8, entry.getValue().get(LnPConstants.PLOC_ID));
            pstatement.setString(9, entry.getValue().get(LnPConstants.ALOC_ID));
            pstatement.setString(10, entry.getValue().get(LnPConstants.SITE_ID));

            pstatement.addBatch();
            batchLimit--;

            if(batchLimit == 0){
                pstatement.executeBatch();
                pstatement.clearBatch
                batchLimit = 1000;
            }
             pstatement.clearParameters();
        }
    }finally{
        //for the remaining ones
        pstatement.executeBatch();

        //commit your updates
        connection.commit();
    }
}finally{
    connection.setAutoCommit(autoCommit);
}