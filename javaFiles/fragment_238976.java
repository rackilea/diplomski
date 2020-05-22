private String projectsAsString;
    ...
public final void convertProjectsToString() {

    String projects = "";

    for (Project p : this.getProjects()) {
        ProjectControl pp = (ProjectControl) p;
        projects += pp.getName() + ", ";
    }
    if (projects != null && projects != "" && projects.length() > 4) {
        projects = projects.substring(0, projects.length() - 2);
    }
    this.projectsAsString = projects;
}