import net.spy.memcached.HashAlgorithm;

import java.io.UnsupportedEncodingException;

public class JenkinsHash implements HashAlgorithm {
    @Override
    public long hash(String k) {
        try {
            int hash = 0;
            for (byte bt : k.getBytes("utf-8")) {
                hash += (bt & 0xFF);
                hash += (hash << 10);
                hash ^= (hash >>> 6);
            }
            hash += (hash << 3);
            hash ^= (hash >>> 11);
            hash += (hash << 15);
            return hash;
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Hash function error", e);
        }
    }
}