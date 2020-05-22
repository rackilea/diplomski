ArrayList<Student> allStudents = new ArrayList();
        allStudents.add(new Student("A", 80, 94));
        allStudents.add(new Student("B", 98, 91));
        allStudents.add(new Student("F", 70, 84));
        allStudents.add(new Student("C", 98, 92));
        allStudents.add(new Student("H", 99, 93));

        Collections.sort(allStudents, new Comparator<Student>() {

            public int compare(Student s, Student s2) {
                return s.getMark() - s2.getMark();
            }
        });