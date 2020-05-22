class Student : Comparable<Student> {
    private String name;
    public Student(String name) {this.name = name;}
    public final String getName() {return name;}
    public final void setName(String name) { this.name = name;}
    public int compareTo<Student>(Student other) {
        return name.compareTo(other.name);
    }
}