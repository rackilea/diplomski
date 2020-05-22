public Course GetCourseByCourseID(String id) {

    for (Course C : CourseArray) {
        if (C.CourseID.equals(id)) {
            return course;
        }
    }
    return null;
}