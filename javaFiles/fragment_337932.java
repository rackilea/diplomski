@Entity
class Course{

   @OneToMany(mappedBy = "course")
   private Set<Student> students;

}

@Entity
class Student

   @ManyToOne
   @JoinColumn(name = "course_id")
   private Course course;

}