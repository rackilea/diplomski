public static List<Student> retrieve() {
    return new AbstractList<Student>(){

        @Override
        public int size() {
            return MAX_STUDENTS;
        }

        @Override
        public Student get(int index) {
            // Make each student on demand.
            Student student = new Student();
            student.setAge(new Integer(index));
            // Date parsing removed because that just untidys the demo.
            student.setName("Student" + index);
            return student;
        }
    };
}