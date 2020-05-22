for (int i = 1; i <= 18; i++) {
    while (grade.equals("")) {
        System.out.println("Please enter your grade for unit " + i + " " + username + ".");
        grade = userinput.next().toLowerCase();
        yr2grade[i - 1] = grade.charAt(0);
        if (yr2grade[i - 1] == 'p') {
            yr2cred[i - 1] = yr2cred[i - 1] + P;
        } else if (yr2grade[i - 1] == 'm') {
            yr2cred[i - 1] = yr2cred[i - 1] + M;
        } else if (yr2grade[i - 1] == 'd') {
            yr2cred[i - 1] = yr2cred[i - 1] + D;
        } else {
            System.err.println("Invalid Grade Supplied! Try Again.\n");
            grade = "";
        }
    }
    grade = "";
}