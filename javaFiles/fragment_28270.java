public class Student {

    private int id;

    @OneToMany(mappedBy = "student")
    @Filter(name = "defaultCoursesFilter")   
    private List<Course> courses;

}

@FilterDef(name = "defaultCoursesFilter"
                , defaultCondition=" notes > 70")
public class Course {

    private int id;

    private String name;

    private float note;

    @ManyToOne
    @Filter(name = "defaultClassromFilter")
    private Classroom classroom;

}


@FilterDef(name = "defaultClassromFilter"
                , defaultCondition=" id  = 23")
public class Classroom {

    private int id;

    private String classroom;

}