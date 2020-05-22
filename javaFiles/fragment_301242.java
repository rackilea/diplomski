public CourseBean() {}

@PostConstruct
public void init() {
    List<Course> target = new ArrayList<Course>();
    courseModel.setSource(getCourseList());
    courseModel = new DualListModel<Course>(source, target);
}