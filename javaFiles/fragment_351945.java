public class Student {
    private String name;
    private String id;
    private ArrayList<Course> listCourses = new ArrayList<>();
    ...

    // this is just a setter for listCourses field
    public void setListCourses(ArrayList<Course> listCourses) {
        this.listCourses = listCourses;
    }
}