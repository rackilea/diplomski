Seq<String> names = JavaConverters.asScalaBuffer(Arrays.asList(topicName));

Seq<BrokerMetadata> brokers = AdminUtils.getBrokerMetadatas(zkUtils,RackAwareMode.Enforced$.MODULE$, Option.empty());

scala.collection.mutable.Map<String, scala.collection.Map<Object, Seq<Object>>> assignment = (scala.collection.mutable.Map<String,     scala.collection.Map<Object, Seq<Object>>>)zkUtils.getPartitionAssignmentForTopics(names);

Map<String, scala.collection.Map<Object, Seq<Object>>> partitionaAssigmentMap = JavaConverters.mutableMapAsJavaMap(assignment);

AdminUtils.addPartitions(zkUtils, topicName, partitionaAssigmentMap.get(topicName), brokers,partitionCount, Option.empty(), false);