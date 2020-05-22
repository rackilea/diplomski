public class ProjectEmployeeItem {
    private final StringProperty name = new SimpleStringProperty(this, "name", "");
    private final StringProperty firstName new SimpleStringProperty(this, "firstname", "");
    private final ObjectProperty<JobTitle> title new SimpleObjectProperty<>(this, "title", null);
    private final ObjectProperty<LocalDate> birthday new SimpleObjectProperty<>(this, "birthday", null);

    // property, get, and set methods ...

    public ProjectEmployeeItem() {
    }

    public ProjectEmployeeItem(Project project) {
        name.bindBidirectional(project.nameProperty());
    }

    public ProjectEmployeeItem(Employee employee) {
        firstname.bindBidirectional(employee.firstnameProperty());
        title.bindBidirectional(employee.titleProperty());
        birthday.bindBidirectional(employee.birthdayProperty());
    }
}