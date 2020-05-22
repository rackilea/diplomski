import redis.clients.jedis.*;
import java.util.*;

public class TestPipeline {

    /**
     * @param args
     */

    int i = 0; 
    Map<String, String> map = new HashMap<String, String>();
    ShardedJedis jedis;  

    // Number of iterations
    // Use 1000 to test with the pipeline, 100 otherwise
    static final int N = 1000;

    public TestPipeline() {
      JedisShardInfo si = new JedisShardInfo("127.0.0.1", 6379);
      List<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
      list.add(si);
      jedis = new ShardedJedis(list);
    } 

    public void push( int n ) {
     ShardedJedisPipeline pipeline = jedis.pipelined();
     for ( int k = 0; k < n; k++) {
      map.put("id", "" + i);
      map.put("name", "lyj" + i);
      pipeline.hmset("m" + i, map);
      ++i;
     }
     pipeline.sync(); 
    }

    public void push2( int n ) {
     for ( int k = 0; k < n; k++) {
      map.put("id", "" + i);
      map.put("name", "lyj" + i);
      jedis.hmset("m" + i, map);
      ++i;
     }
    }

    public static void main(String[] args) {
      TestPipeline obj = new TestPipeline();
      long startTime = System.currentTimeMillis();
      for ( int j=0; j<N; j++ ) {
       // Use push2 instead to test without pipeline
       obj.push(1000); 
       // Uncomment to see the acceleration
       //System.out.println(obj.i);
     }
     long endTime = System.currentTimeMillis();
     double d = 1000.0 * obj.i;
     d /= (double)(endTime - startTime);
     System.out.println("Throughput: "+d);
   }
 }