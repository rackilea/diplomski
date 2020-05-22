public class School {
    private List<String> studentNames = Collections.emptyList();

    public void addStudentName(String name) {
        if (studentNames.isEmpty()) {
            studentNames = new ArrayList<String>();
        }
        studentNames.add(name);
    }

    public void removeStudentName(String name) {
        studentNames.remove(name);
        if (studentNames.isEmpty()) {
            studentNames = Collections.emptyList(); // GC will deallocate the old List
        }
    }
}