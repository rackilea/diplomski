Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                float grade1[] = s1.getSubject().getGrade();
                float grade2[] = s2.getSubject().getGrade();
                Float avg1=null;//calculate average from grade1
            Float avg2=null;//calculate average from grade2

            return avg1.compareTo(avg2);
            }
        });