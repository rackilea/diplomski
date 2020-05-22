// it can be changed to check existence of id
CourseDto courseDto = courses.findById(activityPostDto.getCourseId());
if (courseDto ==null){
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
}

Course course = new Course();
course.setId(activityPostDto.getCourseId()) ;

Activity activity = new Activity();
activity.setCourse(course);
activity = activityService.add(activity);