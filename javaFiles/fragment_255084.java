DownloadService2 service = (DownloadService2) ServiceManager.lookup("javax.jnlp.DownloadService2");
ResourceSpec alljars = new ResourceSpec(".*", ".*", DownloadService2.JAR)
ResourceSpec[] results = service.getCachedResources(alljars);

for (ResourceSpec spec : results) {
    System.out.println(spec.getUrl());
}