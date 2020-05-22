private void printAverageGrade() {
    System.out.println("Total of grades: " + getSum(subjects));
    System.out.println("Count of grades: " + subjects.length);
    double average = getAverage(subjects);
    System.out.println("Your average grade is: " + average);
    System.out.print("Your Grade is ");
    if (average > 80) {
        System.out.println("A");
    } else {
        System.out.println("Failed");
    }
    System.out.println();
}