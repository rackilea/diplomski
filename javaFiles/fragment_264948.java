JobExecutionException e2 = new JobExecutionException(e);
// fix somekey in JobDataMap
dataMap.Put("sampleKey", "1");

// this job will refire immediately
e2.RefireImmediately = true;