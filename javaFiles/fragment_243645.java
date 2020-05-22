private final boolean topologyExists(final String topologyName) {

   // list all the topologies on the local cluster
   final List<TopologySummary> topologies = localCluster.getClusterInfo().get_topologies();

   // search for a topology with the topologyName
   if (null != topologies && !topologies.isEmpty()) {
       final List<TopologySummary> collect = topologies.stream()
               .filter(p -> p.get_name().equals(topologyName)).collect(Collectors.toList());
       if (null != collect && !collect.isEmpty()) {
           return true;
       }
   }
   return false;
}