for (int i = 0; i < finalGrades.length; i++) {
        // check input is an integer
        while (!input.hasNextInt()) {
            System.out.print("Please enter integers only: ");
            input.next();
        }

        finalGrades[i] = input.nextInt();
        if (finalGrades[i] > 100 || finalGrades[i] < 0) {
            System.out
                    .print("Please enter integers between 0 and 100 only:");
            finalGrades[i] = input.nextInt();
        }
        if (i > 0) {
            if (finalGrades[i] < finalGrades[i - 1]) {
                System.out
                        .print("Please enter integers in ascending order       only: ");
                finalGrades[i] = input.nextInt();
                continue;
            }
        }
    }