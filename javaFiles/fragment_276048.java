Dataproc dataproc = new Dataproc.Builder(new NetHttpTransport(), new JacksonFactory(), credential)
    .setApplicationName("my-webabb/1.0")
    .build();
dataproc.projects().regions().jobs().submit(
    projectId, "global", new SubmitJobRequest()
        .setJob(new Job()
            .setPlacement(new JobPlacement()
                .setClusterName("my-spark-cluster"))
            .setSparkJob(new SparkJob()
                .setMainClass("FooSparkJobMain")
                .setJarFileUris(ImmutableList.of("gs://bucket/path/to/your/spark-job.jar"))
                .setArgs(ImmutableList.of(
                    "arg1", "arg2", "arg3")))))
    .execute();