clusterId  //Defined in the code above

TerminateJobFlowsRequest terminate;
terminate = new TerminateJobFlowsRequest().withJobFlowIds(Arrays.asList(new String[] {clusterId});

emrClient.terminateJobFlows(terminate);