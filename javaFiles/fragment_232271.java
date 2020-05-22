public int getCourseIndex(String course){
    for (int i = 0; i<courses.length; i++){
        if(course.equals(courses[i])){
            return i;
        }
    }
    return -1; // not found
}