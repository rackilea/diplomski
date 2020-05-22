List<Course> courses = ...

Collections.sort(courses, new CourseComparatorById());
// now it's sorted by ID

Collections.sort(courses, new CourseComparatorByStartTime());
// now it's sorted by start time