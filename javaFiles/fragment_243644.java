private void runTopology(final StormTopology topology, final String topologyName, final long timeout) {
  LocalCluster localCluster = new LocalCluster();

  // topology configuration.
  final Config configuration = configureTopology();
  configuration.setDebug(true);

  // submit the topology to local cluster.
  localCluster.submitTopology(name, configuration, topology);

  if (timeout >= 0) {
      Utils.sleep(timeout);

      // kill the topology
      final KillOptions killOptions = new KillOptions();
      killOptions.set_wait_secs(0);
      localCluster.killTopologyWithOpts(name, killOptions);

      // wait until the topology is removed from the cluster
      while (topologyExists(name)) {
        // avoid cpu overuse
          Utils.sleep(1000);
      }

      // for some reason I have to wait to be sure topology is stopped and local cluster can be shutdown
      Utils.sleep(5000);
      localCluster.shutdown();

  }
}