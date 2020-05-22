import net.rubyeye.xmemcached.HashAlgorithm;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.impl.ArrayMemcachedSessionLocator;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, MemcachedException, TimeoutException {
        List<InetSocketAddress> addrs = new ArrayList<InetSocketAddress>();
        addrs.add(new InetSocketAddress("127.0.0.1", 11211));
        addrs.add(new InetSocketAddress("172.28.29.22", 11211));
        MemcachedClientBuilder builder = new XMemcachedClientBuilder(addrs);
        builder.setSessionLocator(new ArrayMemcachedSessionLocator(HashAlgorithm.ONE_AT_A_TIME));
        MemcachedClient memcachedClient = builder.build();
        memcachedClient.set("foo", 0, "bar2");
        memcachedClient.set("sample", 0, "key");
        memcachedClient.set("try", 0, "another");
        memcachedClient.set("ax-spadg-list", 0, "3045,6645");
        memcachedClient.shutdown();
        System.out.println("Done");
    }
}