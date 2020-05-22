@Override
public List<TaskResource> findTaskFromProject(Long id) {

    Project project = projectRepository.findOne(id);
    List<Task> tasks = project.getTask();
    List<TaskResource> taskResourceList = new ArrayList<TaskResource>();

    for (Task task : tasks) {
        TaskResource taskResource = new TaskResource();
        taskResource.setName(task.getName());
        taskResource.setDescription(task.getDescription());
        taskResource.setCreatedAt(task.getCreatedAt());
        taskResource.setUpdatedAt(task.getUpdatedAt());
        taskResource.setDeletedAt(task.getDeletedAt());
        taskResource.setIsActive(task.getIsActive());
        taskResource.setRisk(task.getRisk());
        //taskResource.setDocumentState(task.getDocumentState());
        taskResource.setEstimatedStartDate(task.getEstimatedStartDate());
        taskResource.setStartDate(task.getStartDate());
        taskResource.setEstimatedDateEnd(task.getEstimatedDateEnd());
        taskResource.setDateEnd(task.getDateEnd());
        taskResource.setIds(task.getId());
        taskResource.setJob(taskService.findJobsFromTask(task.getId()));
        taskResource.add(linkTo(TaskController.class).slash("").slash(task.getId()).withSelfRel());
        taskResource.add(linkTo(TaskController.class).slash("").slash(task.getId()).withRel("task"));

        taskResourceList.add(taskResource);
    }

    return taskResourceList;
}