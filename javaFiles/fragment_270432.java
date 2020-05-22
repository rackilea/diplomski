// create the actual request
RunInstancesRequest request = new RunInstancesRequest();
request.withMinCount(1).withMaxCount(count);
request.withKeyName("TheOwner");
request.withSecurityGroups("SSH");
request.withInstanceType(InstanceType.T2Micro);
request.withImageId("MyImageID");
request.withRegion(Region.getRegion(Regions.US_EAST_1));

// add a web hook call to notify us when the instance is launched
request.withUserData("#!/bin/bash\ncurl -X POST http://domain.com/email-me");

// launch it
RunInstancesResult awsResponse = awsClient.runInstances(request);