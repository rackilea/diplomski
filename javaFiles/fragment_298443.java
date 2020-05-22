import net.spy.memcached.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws IOException {
        List<InetSocketAddress> addrs = new ArrayList<InetSocketAddress>();
        addrs.add(new InetSocketAddress("127.0.0.1", 11211));
        addrs.add(new InetSocketAddress("172.28.29.22", 11211));
        try {
            ConnectionFactory connectionFactory = new ConnectionFactoryBuilder()
                .setProtocol(ConnectionFactoryBuilder.Protocol.TEXT)
                .setHashAlg(new JenkinsHash())
                .setLocatorType(ConnectionFactoryBuilder.Locator.ARRAY_MOD).build();
            MemcachedClient memcache = new MemcachedClient(connectionFactory, addrs);
            memcache.add("foo", 0, "bar2");
            memcache.add("sample", 0, "key");
            memcache.add("try", 0, "another");
            memcache.add("ax-spadg-list", 0, "3045,6645");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Done");
    }
}