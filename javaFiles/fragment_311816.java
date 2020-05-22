try {

        DateFormat df = DateFormat.getInstance();
        Date startDate = df.parse("28/07/2012 01:00 AM");

        System.out.println("StartDate = " + startDate);

        Date callDate = startDate;

        Calendar today = Calendar.getInstance();
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);

        System.out.println("Today = " + today.getTime());

        // If this date time is already passed
        // Tue Jul 31 12:18:09 EST 2012 is after Sat Jul 28 01:00:00 EST 2012
        if (today.after(start)) {

            //then I need to get the current date, set the time part from above string in the current date
            Calendar timeMatch = Calendar.getInstance();
            timeMatch.setTime(startDate);
            timeMatch.set(Calendar.DATE, today.get(Calendar.DATE));
            timeMatch.set(Calendar.MONTH, today.get(Calendar.MONTH));
            timeMatch.set(Calendar.YEAR, today.get(Calendar.YEAR));

            //& if this time is also already passed, then get the next day & set the time part from above string in it
            if (timeMatch.after(today)) {

                timeMatch.add(Calendar.DATE, 1);

            }

            callDate = timeMatch.getTime();

        }

        System.out.println("CallDate = " + callDate);

    } catch (ParseException exp) {

        exp.printStackTrace();

    }