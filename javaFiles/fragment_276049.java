import java.util.UUID;

...

Dataproc dataproc = new Dataproc.Builder(new NetHttpTransport(), new JacksonFactory(), credential)
    .setApplicationName("my-webabb/1.0")
    .build();

String curJobId = "json-agg-job-" + UUID.randomUUID().toString();
Job jobSnapshot = null;
try {
  jobSnapshot = dataproc.projects().regions().jobs().submit(
      projectId, "global", new SubmitJobRequest()
          .setJob(new Job()
              .setReference(new JobReference()
                   .setJobId(curJobId))
              .setPlacement(new JobPlacement()
                  .setClusterName("my-spark-cluster"))
              .setSparkJob(new SparkJob()
                  .setMainClass("FooSparkJobMain")
                  .setJarFileUris(ImmutableList.of("gs://bucket/path/to/your/spark-job.jar"))
                  .setArgs(ImmutableList.of(
                      "arg1", "arg2", "arg3")))))
      .execute();
} catch (IOException ioe) {
  try {
    jobSnapshot = dataproc.projects().regions().jobs().get(
        projectId, "global", curJobId).execute();
    logger.info(ioe, "Despite exception, job was verified submitted");
  } catch (IOException ioe2) {
    // Handle differently; if it's a GoogleJsonResponseException you can inspect the error
    // code, and if it's a 404, then it means the job didn't get submitted; you can add retry
    // logic in that case.
  }
}

// We can poll on dataproc.projects().regions().jobs().get(...) until the job reports being
// completed or failed now.