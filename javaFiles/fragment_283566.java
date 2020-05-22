public void searchCourse(String courseName) {
    for(int i = 0; i < schedule.length; i++) {
        if(courseName.equals(schedule[i].substring(0, 6))) {
            System.out.println("Course Found at: " + i);
            return;
        }
    }

    System.out.println("Course Not Found");
}