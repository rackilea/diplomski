...
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
...
        HTable htable = null;
        try {
            htable = new HTable(conf, "mytable");
            List<Get> queryRowList = new ArrayList<Get>();
            queryRowList.add(new Get(Bytes.toBytes("mykey1:myhash1")));
            queryRowList.add(new Get(Bytes.toBytes("mykey1:myhash2")));
            queryRowList.add(new Get(Bytes.toBytes("mykey1:myhash3")));
            queryRowList.add(new Get(Bytes.toBytes("mykey2:myhash5")));

            Result[] results = htable.get(queryRowList);
            for (Result r : results) {
                //do something
            }
        }
        finally {
            if (htable != null) {
                htable.close();
            }
        }
...