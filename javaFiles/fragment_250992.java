AmazonElasticMapReduce emr=new AmazonElasticMapReduceClient(
.

.

// Run the job flow
 RunJobFlowResult result = emr.runJobFlow(request)

//shutdown when you notice any error

 emr.shutdown();