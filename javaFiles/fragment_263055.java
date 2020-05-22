String partitionId = "0"; // API to get PartitionIds will be released soon
PartitionReceiver receiver = ehClient.createReceiver(
            EventHubClient.DefaultConsumerGroupName, 
            partitionId, 
            PartitionReceiver.StartOfStream,
            false).get();