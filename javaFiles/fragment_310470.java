MutationBatch m = CassandraAstyanaxConnection.getInstance().getKeyspace().prepareMutationBatch();
 ColumnListMutation<String> clm = m.withRow(CassandraAstyanaxConnection.getInstance().getEmp_cf(), userId);
 for(String key: attributeMap.keySet()){
     clm.putColumn(key, attributeMap.get(key), null);
 }

try {
    m.execute();
} catch (ConnectionException e) {
    e.printStackTrace();
}