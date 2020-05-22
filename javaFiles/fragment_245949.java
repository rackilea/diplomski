public class ProjectConfigTableContentProvider implements IStructuredContentProvider {
    private List<ProjectDirectory> projectEntitiesList;

    @Override
    public Object[] getElements(Object arg0) {
        // TODO Auto-generated method stub
        if (arg0 instanceof Project){
            Project project = (Project) arg0; 
            if (project != null && project.getProjectDirectoriesList() != null){
                initializeTableProjectConfig(project);
                return projectEntitiesList.toArray();
            }
        }
        projectEntitiesList = new ArrayList<ProjectDirectory>();
        return projectEntitiesList.toArray();
    }

    private void initializeTableProjectConfig(Project project){
        try {
            List<ProjectDirectory> listProjectDirectory = new ArrayList<ProjectDirectory>();
            for (ProjectDirectory projectDirectory : project.getProjectDirectoriesList()) {
                if (projectDirectory != null) 
                    listProjectDirectory.add(projectDirectory);
            }
            this.projectEntitiesList = listProjectDirectory;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}