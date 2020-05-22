public String [] getWeekDayPrev()
    {

        weekDaysCount--;
        Calendar now1 = Calendar.getInstance();
        Calendar now = (Calendar) now1.clone();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String [] days = new String[7];
        int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 1;
        now.add(Calendar.WEEK_OF_YEAR , weekDaysCount);
        now.add(Calendar.DAY_OF_MONTH , delta);
        for (int i = 0; i < 7; i++)
            {
                days [i] = format.format(now.getTime());
                now.add(Calendar.DAY_OF_MONTH , 1);
            }

        return days;

    }