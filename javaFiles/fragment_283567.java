public void searchCourse(String courseName) {    
    boolean flag = false;
    int index = 0;

    while(index < schedule.length && !flag) {
        String extract = schedule[index].substring(0,6);
        if (courseName.equals(extract)){
            flag = true;
        } else {
            index++;
        }
    }

    if (!flag){
        System.out.println("Course Not Found");
    } else {
        System.out.println("Course Found at: " + index);
    }
}