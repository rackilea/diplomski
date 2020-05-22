public static void main(String[] args) throws IOException {

        Configuration conf = HBaseConfiguration.create();
        HTable table = new HTable(conf, "demo");
        Scan s = new Scan();
        ResultScanner rs = table.getScanner(s);
        int check = 0;
        for(Result r : rs){
            if(++check > 3)
                break;              
            for (KeyValue kv : r.raw()){                    
                System.out.println("Qualifier : " + Bytes.toString(kv.getQualifier()));
            }                           
        }
        rs.close();
        table.close();
    }
}