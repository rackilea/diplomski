public static void main(String[] args) {

    Student[] students = new Student[25];

    Student s1 = new Student("John", new int[] { 98, 92, 81 });
    Student s2 = new Student("Claire", new int[] { 75, 84, 91, 39 });
    Student s3 = new Student("Steven", new int[] { 88, 94, 65, 91, 95 });
    Student s4 = new Student("Jason", new int[] { 97, 89, 85, 82 });

    List<Student> stuList = new ArrayList<Student>();
    stuList.add(s1);
    stuList.add(s2);
    stuList.add(s3);
    stuList.add(s4);

    int numStudents = loadStudents(students, stuList);
    printStudents(students, numStudents);

}

public static int loadStudents(Student[] s, List<Student> list) {
    int size = list.size();
    for (int i = 0; i < list.size(); i++) {
        s[i] = list.get(i);
        System.out.println(s[i]);
    }
    return size;
}

public static void printStudents(Student[] s, int numStudents) {
    if (numStudents == 0) {
        return;
    }
    if (numStudents < s.length) {
        System.out.println(s[numStudents]);
        printStudents(s, numStudents - 1);
    }
}