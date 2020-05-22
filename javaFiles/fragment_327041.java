Calendar now = Calendar.getInstance();
        int currentDay = now.get(Calendar.DAY_OF_WEEK);

        Calendar school = Calendar.getInstance();
        school.add(Calendar.DAY_OF_YEAR, 1);

        if (currentDay == Calendar.SATURDAY)
        {
            school.add(Calendar.DAY_OF_YEAR, 1);
        }
        else if (currentDay == Calendar.FRIDAY)
        {
            school.add(Calendar.DAY_OF_YEAR, 2);
        }

        school.set(Calendar.HOUR_OF_DAY, 8);
        school.set(Calendar.MINUTE, 30);

        long millisLeft = school.getTimeInMillis() - now.getTimeInMillis();
        long hoursLeft = millisLeft / (60 * 60 * 1000);
        long minutesLeft =  (millisLeft % (60 * 60 * 1000)) / (60 * 1000);