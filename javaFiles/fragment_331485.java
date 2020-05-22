import redis.clients.jedis.*;
import java.util.*;
import com.jcraft.jsch.*;

public class TestTunnel {

    Jedis jedis;  
    Session session;
    JSch jsch = new JSch(); 
    int port;

    // None of the following should be hardcoded
    static String USER = "user";          // SSH user on the redis server host
    static String PASSWD = "XXXXXXXX";    // SSH user password
    static String HOST = "192.168.1.62";  // Redis server host
    static int PORT = 6379;               // Redis server port

    public TestTunnel() {
      try {
        // Open the SSH session
        session = jsch.getSession( USER, HOST, 22 );
        session.setPassword( PASSWD );
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        config.put("Compression", "yes");
        config.put("ConnectionAttempts","3");
        session.setConfig(config);
        session.connect();
        // Setup port forwarding from localhost to the Redis server
        // Local port is ephemeral (given by the OS)
        // Jedis connects to localhost using the local port
        port = session.setPortForwardingL( 0, HOST, PORT );
        jedis = new Jedis( "127.0.0.1", port );
      } catch ( JSchException e ) {
        // Proper error handling omitted
        System.out.println(e);
      }
    } 

    public void disconnect() {
      jedis.disconnect();
      try {
        session.delPortForwardingL( port );
        session.disconnect();            
      } catch ( JSchException e ) {
        // Proper error handling omitted
        System.out.println(e);
      } 
    }

    public void mytest( int n ) {
     for ( int k = 0; k < n; k++) {
      jedis.set("k" + k, "value"+k);
     }
     System.out.println("Read: "+jedis.get("k0") );
    }

    public static void main(String[] args) {
      TestTunnel obj = new TestTunnel();
      obj.mytest(10);
      obj.disconnect();
    }
 }