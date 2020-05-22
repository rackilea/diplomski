void getRegionOfTable(String tabName){
    org.apache.hadoop.hbase.TableName tn = org.apache.hadoop.hbase.TableName.valueOf(tabName);
    org.apache.hadoop.conf.Configuration config = HBaseConfiguration.create();
    HRegionInfo ob;
    try{
        HBaseAdmin hba = new HBaseAdmin(config);
        List<HRegionInfo> lr = hba.getTableRegions(tn);
        Iterator<HRegionInfo> ir = lr.iterator();
        while(ir.hasNext()){
            ob = ir.next();
            System.out.println(ob.getRegionNameAsString());
        }
        hba.close();
    }catch(Exception ex){
        ex.printStackTrace();
    }
}