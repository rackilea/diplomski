final class ApiThrowables {

       static final int BAD_REQUEST = 400; 
       static final int NOT_FOUND   = 404;

       public static ApiException newCourseIdNotFound(String courseId) {
          return new ApiException(2, NOT_FOUND,"Course with ID [" + courseId + "] does not exist.");
       }

       public static ApiException newBadCourseId(String courseId) {
          return new ApiException(2, BAD_REQUEST,"Course ID [" + courseId + "] is not valid.");
       }

    }