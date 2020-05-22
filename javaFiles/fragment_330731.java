public class CustomHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().withDetail("Status Code", "SUCCESS").build();
    }

    private void doHealthCheck() {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, localhost:9092);
        AdminClient adminClient =  AdminClient.create(props);
        try {
            DescribeClusterOptions dco = new DescribeClusterOptions();
            dco.timeoutMs(30000);
            adminClient.describeCluster(dco).clusterId().get();
        } catch (Exception e) {
            System.exit(-1);
        } finally {
            adminClient.close();
            adminClient = null;
        }
    }

}