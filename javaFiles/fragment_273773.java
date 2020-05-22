class Student implements Comprable<Student> { 
....
    public int compareTo( Student other ) { 
        return this.marks - other.marks;
    }
 ...
}