@Test
public void testPostCourseException() {
    Course course = null;
    //initialize the class here or in setup or on class level
    // Ex if your class name is CourseService
    CourseService courseService  = new CourseService();

    Assertions.assertThrows(ExceptionWrapper.class, () -> {
        courseService.postCourse(course);
    });

}