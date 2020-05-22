void addCourse(int CN) {
    for (int i = 0; i < listOfCourses.length; i++) {
        if (listOfCourses[i] == 0) {
            listOfCourses[i] = CN;
        }
    }
    numCoures++;
}