public static Student[] initialize() throws FileNotFoundException {
    Scanner reader = new Scanner(new File("data.txt"));
    int size = reader.nextInt();
    Student[] students = new Student[size];
    int index = 0;

    while (reader.hasNextLine()) {
        double grades = reader.nextDouble();
        String firstName = reader.next();
        String lastName = reader.next();

        Student student = new Student(firstName, lastName, grades);

        boolean duplicate = false;
        for (int i = 0; i < students.length; i++) {
            if (student.equals(students[i])) {
                duplicate = true;
                break;
            }
        }

        if (!duplicate) {
            students[index] = student;
            index++;
        }
    }

    reader.close(); // <--- Make sure to close the Scanner
    return students;
}