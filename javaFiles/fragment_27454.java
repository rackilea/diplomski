private String startInstance(final String instanceId, AmazonEC2 ec2, final BuildLogger buildLogger)
        throws AmazonServiceException, AmazonClientException, InterruptedException
{
    StartInstancesRequest startRequest = new StartInstancesRequest().withInstanceIds(instanceId);
    StartInstancesResult startResult = ec2.startInstances(startRequest);
    List<InstanceStateChange> stateChangeList = startResult.getStartingInstances();
    buildLogger.addBuildLogEntry("Starting instance '" + instanceId + "':");

    // Wait for the instance to be started
    return waitForTransitionCompletion(stateChangeList, "running", ec2, instanceId, buildLogger); }