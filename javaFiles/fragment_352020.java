@Mapper
public abstract class SchoolMapper {
    public School toSchool(SchoolDto school) {
        return toSchool( school, school.getCourses() );
    }

    protected abstract School toSchool(SchoolDto school, @Context List<CourseDto> courses);

    @Mapping(target = "courses", ignore = true) // see afterMappingToTeacher
    protected abstract Teacher toTeacher(TeacherDto teacher, @Context List<CourseDto> courses);

    protected abstract Course toCourse(CourseDto course);

    @AfterMapping
    void afterMappingToTeacher(@MappingTarget target, TeacherDto source, @Context List<CourseDto> courses) {
        // omitted null-checks

        List<Course> courses = new ArrayList<>();
        for(CourseDto course : courses) {
            if(course.getTeacherId().equals(source.getId())) {
                courses.add( toCourse(course) );
            }
        }

        target.setCourses( courses );
    }
}