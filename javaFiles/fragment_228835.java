public Long insertRows(String projectId, 
                       String datasetId, 
                       String tableId, 
                       InputStream schema,
                       AbstractInputStreamContent data) {
    try {

        // Defining table fields
        ObjectMapper mapper = new ObjectMapper();
        List<TableFieldSchema> schemaFields = mapper.readValue(schema, new TypeReference<List<TableFieldSchema>>(){});
        TableSchema tableSchema = new TableSchema().setFields(schemaFields);

        // Table reference
        TableReference tableReference = new TableReference()
                .setProjectId(projectId)
                .setDatasetId(datasetId)
                .setTableId(tableId);

        // Load job configuration
        JobConfigurationLoad loadConfig = new JobConfigurationLoad()
                .setDestinationTable(tableReference)
                .setSchema(tableSchema)
                // Data in Json format (could be CSV)
                .setSourceFormat("NEWLINE_DELIMITED_JSON")
                // Table is created if it does not exists
                .setCreateDisposition("CREATE_IF_NEEDED")
                // Append data (not override data)
                .setWriteDisposition("WRITE_APPEND");
        // If your data are coming from Google Cloud Storage
        //.setSourceUris(...);

        // Load job
        Job loadJob = new Job()
                .setJobReference(
                        new JobReference()
                                .setJobId(Joiner.on("-").join("INSERT", projectId, datasetId,
                                        tableId, DateTime.now().toString("dd-MM-yyyy_HH-mm-ss-SSS")))
                                .setProjectId(projectId))
                .setConfiguration(new JobConfiguration().setLoad(loadConfig));
        // Job execution
        Job createTableJob = bigquery.jobs().insert(projectId, loadJob, data).execute();
        // If loading data from Google Cloud Storage
        //createTableJob = bigquery.jobs().insert(projectId, loadJob).execute();

        String jobId = createTableJob.getJobReference().getJobId();
        // Wait for job completion
        createTableJob = waitForJob(projectId, createTableJob);
        Long rowCount = createTableJob != null ? createTableJob.getStatistics().getLoad().getOutputRows() : 0l;
        log.info("{} rows inserted in table '{}' (dataset: '{}', project: '{}')", rowCount, tableId, datasetId, projectId);
        return rowCount;
    }
    catch (IOException e) { throw Throwables.propagate(e); }
}