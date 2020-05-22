Properties props = new Properties();
props.put("bootstrap.servers", "localhost:9092,localhost:9093");

AdminClient adminClient = AdminClient.create(props);
DescribeClusterResult describeClusterResult = adminClient.describeCluster();
Collection<Node> clusterDetails = describeClusterResult.nodes().get();