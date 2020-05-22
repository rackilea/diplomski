public void massDelete(byte[] tableName) throws IOException {
    HTable table=(HTable)hbasePool.getTable(tableName);

    String tablePrefix = "user_";
    int startRange = 500;
    int endRange = 999;

    List<Delete> listOfBatchDelete = new ArrayList<Delete>();

    for(int i=startRange;i<=endRange;i++){
        String key = tablePrefix+i; 
        Delete d=new Delete(Bytes.toBytes(key));
        listOfBatchDelete.add(d);  
    }

    try {
        table.delete(listOfBatchDelete);
    } finally {
        if (hbasePool != null && table != null) {
            hbasePool.putTable(table);
        }
    }
}