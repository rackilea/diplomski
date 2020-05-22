class StudentVO implements Comparable<StudentVO>{
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public int compareTo(StudentVO o) {
        return ((Integer)getAge()).compareTo(o.getAge());
    }
}

class NameComparator implements Comparator<StudentVO> {

    @Override
    public int compare(StudentVO o1, StudentVO o2) {
        return o1.getName().compareTo(o2.getName());
    }

 }