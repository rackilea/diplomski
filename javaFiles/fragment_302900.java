public class CourseComparatorById implements Comparator<Course> {

    @Override
    public int compare(Course o1, Course o2) {
        // for example - sort ascending by ID
        return o1.getId() - o2.getId();
    }
}

public class CourseComparatorByStartTime implements Comparator<Course> {

    @Override
    public int compare(Course o1, Course o2) {
        // for example - sort ascending by start time
        return o1.getStartTime() - o2.getStartTime();
    }
}