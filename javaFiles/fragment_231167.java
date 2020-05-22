public class ProjectSet implements Iterable<Project> {
    private ArrayList<Project> projects;
    public ProjectSet() {
        this.projects = new ArrayList<Project>();
    }

    // .. iteration methods ??
   @Override
   public Iterator<Project> iterator() {
       return projects.iterator();
   }
}