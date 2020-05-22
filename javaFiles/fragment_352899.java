public String getProjectNotNull(MantisTask mantisTask) {
    if (mantisTask == null){
        return null;
    }

    String project = "-";

    // check whatever may be null here
    if (mantisTask.getProject() != null
        && mantisApiCache.getProject(mantisTask.getProject()) != null)  {

        project = mantisApiCache.getProject(mantisTask.getProject()).getName();

    } else {
        log.info("TaskService.getProjectNotNull() throws controled null")
    }

    return project;
}