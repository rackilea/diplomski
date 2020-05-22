int total; // Total Minutes
    String time; // Input from keyboard

    final Scanner T = new Scanner(System.in);

    System.out.print("Enter the time in HH:MM :");
    time = T.next();

    boolean correctFormat = false;
    int hour = 0, minute = 0;

    while (!correctFormat) {
        correctFormat = true;

        if (time.length() != 5)
            correctFormat = false;
        else {
            try {
                hour = Integer.parseInt(time.substring(0, 2));
                minute = Integer.parseInt(time.substring(3, 5));
            } catch (NumberFormatException e) {
                correctFormat = false;
            }
            if (correctFormat) {
                if (hour >= 24 || hour < 0)
                    correctFormat = false;

                if (minute >= 60 || minute < 0)
                    correctFormat = false;
            }
        }
        if (!correctFormat) {
            System.out.print("Pleaase follow the format! Enter the time in HH:MM :");
            time = T.next();
        }
    }

    // Formula of the calculation
    total = hour * 60 + minute;

    // Display the final value
    System.out.println(time + " is " + total + " minutes.");