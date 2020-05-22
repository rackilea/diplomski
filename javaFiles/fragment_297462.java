@Component
@FeignClient("CourseStudent")
public interface ICourseStudentClient {

    @RequestLine("GET /{id}")
    CourseStudents getOneById(@Param("id") Long id);
}