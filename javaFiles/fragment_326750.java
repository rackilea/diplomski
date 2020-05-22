IProjectDescription description = ResourcesPlugin.getWorkspace().loadProjectDescription(new Path(BuildPath + "/.project")); 
IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(description.getName());
IProject[] array = ResourcesPlugin.getWorkspace().getRoot().getProjects();
for(int count = 0; count <= array.length - 1; count ++){
  if(project.equals(array[count])){
    array[count].close(null);
    array[count].delete(true, null);
  }
}
project.create(description, null);
project.open(null);