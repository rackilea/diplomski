import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.BoundedExponentialBackoffRetry;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class LoadConfigsInZoo {
    // base path of your config
    // /CONFIG_PATH/APP_NAME,CONTEXT_NAME
    private static final String BASE_PATH = "/configuration/myApp";
    private static final String ZOO_URL = "localhost:2181";
    private static final String CONFIG_FILE = "bootstrap.yml";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        new LoadConfigsInZoo().loadConfig();
    }

    private void loadConfig() throws IOException {
        BoundedExponentialBackoffRetry retryPolicy =
                new BoundedExponentialBackoffRetry(100, 300, 10);
        Map<String, String> config = flattenInnerProperties("", getContentOfYaml(CONFIG_FILE));

        try (CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(ZOO_URL)
                .retryPolicy(retryPolicy)
                .build()) {
            client.start();
            for (Map.Entry<String, String> entry : config.entrySet()) {
                String path = createPath(BASE_PATH, entry.getKey());
                try {
                    log.info("Try add node with name '{}'", path);
                    client.create()
                            .creatingParentsIfNeeded()
                            .forPath(path, entry.getValue().getBytes());
                    log.info("Node with name '{}' was created", path);
                } catch (Exception e) {
                    log.warn("Unable to create node by path: {}, exception: {}", path, e.getMessage());
                }
            }
        }
    }

    // need your own implementation for properties/json files
    @SuppressWarnings("unchecked")
    private Map<String, Object> getContentOfYaml(String path) throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream in = new ClassPathResource(path).getInputStream()) {
            return yaml.loadAs(in, Map.class);
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> getContentOfProperties(String path) throws IOException {
        try (InputStream in = new ClassPathResource(path).getInputStream()) {
            Properties properties = new Properties();
            properties.load(in);
            return (Map) (properties);
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> getContentOfJson(String path) throws IOException {
        try (InputStream in = new ClassPathResource(path).getInputStream()) {
            return new ObjectMapper().readValue(in, HashMap.class);
        }
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> flattenInnerProperties(String prefix, Map<String, Object> rootMap) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, Object> entry : rootMap.entrySet()) {
            String newPrefix = prefix.isEmpty() ? entry.getKey() : prefix + "." + entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                result.putAll(flattenInnerProperties(newPrefix, (Map<String, Object>) value));
            } else if (value instanceof List) {
                result.putAll(flattenInnerListInProperties(newPrefix, (List) value));
            } else {
                result.put(newPrefix, String.valueOf(value));
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> flattenInnerListInProperties(String prefix, List value) {
        int i = 0;
        Map<String, String> result = new HashMap<>();
        for (Object v : value) {
            String listKey = prefix + "[" + i + "]";
            if (v instanceof Map) {
                result.putAll(flattenInnerProperties(listKey, (Map) v));
            } else if (v instanceof List) {
                result.putAll(flattenInnerListInProperties(listKey, (List) v));
            } else {
                result.put(listKey, String.valueOf(v));
            }
            i++;
        }
        return result;
    }

    private String createPath(String basePath, String configName) {
        return basePath + "/" + configName.replaceAll("\\.", "/");
    }
}