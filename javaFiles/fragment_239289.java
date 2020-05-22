public List<JobResource> findJobsFromTask(Long id) {

    Task task = taskRepository.findOne(id);
    List<Job> jobs = task.getJob(); 
    List<JobResource> jobResourceList = new ArrayList<JobResource>();

    for (Job job : jobs) {
        jobResourceList.add(new JobResourceAssembler().toResource(job));
    }
    return jobResourceList;
}