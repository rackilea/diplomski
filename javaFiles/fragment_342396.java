HTable table = new HTable(conf, "tablename");
Get get = new Get(rowkey.getBytes());     
get.addFamily(family.getBytes());    // <-----------------       
Result rs = table.get(get);
for (KeyValue kv : rs.raw()) {
    holdvalue = new String(kv.getValue());
}