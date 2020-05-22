Collections.sort(studentList,new Comparator<Student>() {
         @Override
        public int compare(Student s1, Student s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
        }
    });