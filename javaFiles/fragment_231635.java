@Entity
public class Student {
    ...
    @OneToMany(mappedBy = "student")
    private List<CourseMember> courseMemberList;

}

@Entity
public class Course {
    ...
    @OneToMany(mappedBy = "course")
    private List<CourseMember> courseMemberList;

}