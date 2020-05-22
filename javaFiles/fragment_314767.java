for (int month = 1; month <= 12; month++) {
        outputFile.println("\n          " + getMonthName(month));
        outputFile.println("Sun Mon Tue Wed Thu Fri Sat");
        int numDays = getNumberofDays(month, year);

        int[] week = new int[7];
        for (int day = 1; day <= numDays; day++) {
            int dayWeek = getDayofTheWeek(day, month, year);
            week[dayWeek] = day;

            // did we reach the 7th day of the week or the last day of the month?
            if ((dayWeek + 1) % 7 == 0 || day == numDays) {
                // print the week as one row
                for (int d : week) {
                    // don't print 0 values
                    outputFile.printf("%3s ", d == 0 ? "" : d);
                }
                outputFile.println("");
                // reset the array to store a new row in the next loop iteration
                week = new int[7];
            }
        }
        outputFile.println("");
    }