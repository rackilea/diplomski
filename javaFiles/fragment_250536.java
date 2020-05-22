// name and group are the primary key of the job detail
final JobDetail jobDetail = new JobDetail(name, group, ExtendedReportJob.class);

// reportSchedule is the object I've previously modified
jobDetail.getJobDataMap().put(ORStatics.REPORT_SCHEDULE, reportSchedule);
jobDetail.setDescription(reportSchedule.getScheduleDescription());

// overwrite the previous job, however retaining the triggers       
scheduler.addJob(jobDetail, true);