for (int s = 0; s < student; s++) {
        System.out.println("Student number " + (s + 1));


        for (int i = 0; i < count; i++) {
            System.out.println("Enter score no." + (i + 1) + " : ");
            grade = keyboard.nextInt();
            sum += grade;
            average = sum / count;

        }

        System.out.println("The average is " + average);

        sum = 0;  //THIS IS REQUIRED
    }