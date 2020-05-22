package injectcontext;

import io.micronaut.discovery.DiscoveryClient;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class DiscoveryHelper {

    private final DiscoveryClient consulClient;

    public DiscoveryHelper(DiscoveryClient consulClient) {
        this.consulClient = consulClient;
    }

    public Publisher<List<String>> getIds() {
        // do whatever you want with the ids...
        return consulClient.getServiceIds();
    }
}