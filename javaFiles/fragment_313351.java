System.out.print("\nGrades below 65 : ");
for (int i = 0; i < takeCoursesNum; i++) {
    if (grades[i] < 65) {
        System.out.print(grades[i]);
    }
}

System.out.print("\nGrades below 90 : ");
for (int i = 0; i < takeCoursesNum; i++) {
    if (grades[i] > 90) {
        System.out.print(grades[i]);
    }
}

System.out.print("\nGrades between 65 and 90: ");
for (int i = 0; i < takeCoursesNum; i++) {
    if (grades[i] > 65 && grades[i]<90) {
        System.out.print(grades[i]);
    }
}