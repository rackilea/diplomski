public void studentRanking() {
        Scanner read = new Scanner(System.in);

        System.out.println("MIDTERM EXAM: STUDENT RANKING");
        System.out.print("Enter # of Student: ");
        int noOfStudent = read.nextInt();
        System.out.print("Enter # of Subject: ");
        int noOfSubject = read.nextInt();

        String[] subjects = new String[noOfSubject];
        System.out.println("Enter your " + noOfSubject + " subjects: ");
        for (int i = 0 ; i < noOfSubject; i++) {
            System.out.print((i+1) + ". ");
            subjects[i] = read.next();
        }
        String[] students = new String[noOfStudent];
        double[] grade = new double[noOfSubject];
        double[] total = new double[noOfStudent];
        double[] average = new double[noOfStudent];
        double[] allGrades = new double[noOfStudent * noOfSubject];
        int t = 0;

        for (int i = 0, k = 0; i < noOfStudent; i++, k++) {
            System.out.print((i + 1) + ". Name: ");
            students[i] = read.next();
            for (int j = 0; j < noOfSubject; j++) {
                System.out.print("\t Grade in " + subjects[j] + ": ");
                grade[j] = read.nextDouble();
                allGrades[t++] = grade[j];
            }
            for (int g = 0; g < noOfSubject; g++) {
                total[k] += grade[g];
            }
            average[k] = total[k] / noOfSubject;
            System.out.println("Average: " + average[i]);
        }

        for (int c = 0; c < noOfStudent; c++) {
            System.out.println(average[c]);
        }
    }