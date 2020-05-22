public class Student {
    private LocalTime time;
    private String name;

    public Student(LocalTime time, String name) {
        this.time = time;
        this.name = name;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    //TODO add the other fields
}