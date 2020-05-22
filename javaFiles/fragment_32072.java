AWSCredentials credentials;
credentials = new BasicAWSCredentials("myAccessKey", "mySecretKey");

AmazonElasticMapReduceClient emrClient;
emrClient = new AmazonElasticMapReduceClient(credentials);
emrClient.setEndpoint("elasticmapreduce.eu-west-1.amazonaws.com");

ListClustersRequest req;
req = new ListClustersRequest().withClusterStates(ClusterState.TERMINATED_WITH_ERRORS);

ListClustersResult res;
res = emrClient.listClusters(req);

int size  = res.getClusters().size();

System.out.println("***************** CLUSTER LIST ***************");
System.out.println("*** Size: " + size);

for(int i = 0 ; i < size; i++){           
    String clusterID = res.getClusters().get(i).getId();
    System.out.println(">>> Cluster: " + clusterID);    
}