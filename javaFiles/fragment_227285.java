public class Course {

    public void enroll( User user, Student student ) {
       if( user.hasPermission( Permission.OVERRIDE_COURSE_RULES ) ) {
           add( student );
       } else if( hasEnrollmentDatePassed() ) {
           throw new CourseException( "Enrollment date has passed." );
       } else if( isClassFull() ) {
           throw new CourseException( "Course is full" );
       } else {
           add( student );
       }
    }
}