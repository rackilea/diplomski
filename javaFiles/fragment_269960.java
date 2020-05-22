double avg = 0;
    int failCounter = 0;

    String[] keywords = in.nextLine().split(" ");
    int studentNumber = Integer.parseInt(keywords[0]);
    double examValue = Double.parseDouble(keywords[1]);

    for (int i = 0; i < studentNumber; i++) {
        keywords = in.nextLine().split(" ");
        String studentName = keywords[0];
        double studentMark = Double.parseDouble(keywords[1]);
        double grade = calculateTotalGrade(studentMark, examValue);
        failCounter += (hasFailed(grade) ? 1 : 0);
        avg += grade;
        outPut.println(String.format("%s \t\t %.2f \t\t %s", studentName, grade, hasFailed(grade) ? "failed" : "passed"));
    }
    avg = avg / studentNumber;
    outPut.println("class average: " + avg);
    outPut.println("passed: " + (studentNumber - failCounter));
    outPut.println("failed: " + failCounter);