my.package

public class StratusDiscoveryExclusionFilter implements AutoConfigurationImportFilter {

private static final Set<String> SHOULD_SKIP = new HashSet<>(
        Arrays.asList(
                // DiscoveryClient Beans
                "org.springframework.cloud.client.discovery.composite.CompositeDiscoveryClientAutoConfiguration",
                "org.springframework.cloud.client.discovery.simple.SimpleDiscoveryClientAutoConfiguration",
                // Health indicators
                "org.springframework.cloud.client.CommonsClientAutoConfiguration")
);

/**
 * For each class name, provide an assocated boolean array indicated whether or not to include
 */
@Override
public boolean[] match(String[] classNames, AutoConfigurationMetadata metadata) {
    boolean[] matches = new boolean[classNames.length];

    for (int i = 0; i < classNames.length; i++) {
        matches[i] = !SHOULD_SKIP.contains(classNames[i]);
    }
    return matches;
 }
}