String master = "https://192.168.42.20:8443/";

Config config = new ConfigBuilder().withMasterUrl(master).build();
try (final KubernetesClient client = new DefaultKubernetesClient(config)) {
  // Simple Listing:
  PodList simplePodList = client.pods().inAnyNamespace().list();      

  // List with limit and continue options:
  PodList podList = client.pods().inAnyNamespace().list(5, null);
  podList.getItems().forEach((obj) -> { System.out.println(obj.getMetadata().getName()); });

  podList = client.pods().inAnyNamespace().list(5, podList.getMetadata().getContinue());
  podList.getItems().forEach((obj) -> { System.out.println(obj.getMetadata().getName()); });

} catch (KubernetesClientException e) {
  logger.error(e.getMessage(), e);
}