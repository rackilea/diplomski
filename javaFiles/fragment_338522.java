@XmlElement
@java.lang.SuppressWarnings("all")
@javax.annotation.Generated("lombok")
public List<Student> getStudents() {
    Object value = this.students.get();
    if (value == null) {
        synchronized (this.students) {
            value = this.students.get();
            if (value == null) {
                final List<Student> actualValue = new ArrayList<Student>();
                value = actualValue == null ? this.students : actualValue;
                this.students.set(value);
            }
        }
    }
    return (List<Student>)(value == this.students ? null : value);
}

private final AtomicReference<Object> students = new AtomicReference<Object>();