JobConfigurationQuery queryConfig = new JobConfigurationQuery().setQuery(<querySql>);
queryConfig.setDestinationTable(<destination_table>);
queryConfig.setWriteDisposition("WRITE_APPEND");
Job job = new Job().setConfiguration(new JobConfiguration().setQuery(queryConfig));

bigquery.jobs().insert(projectId, job).execute();