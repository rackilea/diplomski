for (int j = 0; j < course.length; j++) {
        courseName = course[j];
        System.out.println(courseName + "\t");
    }
    for (int m = 0; m < marks.length; m++) {
        for (int n = 0; n < marks.length; n++) {
            courseMarks = marks[m][n];
            System.out.print("\t\t" + courseMarks + "\t\t");
        }
        System.out.println("");
    }