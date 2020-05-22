try
    {
        CalendarView cv = (CalendarView) this.findViewById(R.id.calendarView1);
        Class<?> cvClass = cv.getClass();
        Field field = cvClass.getDeclaredField("mMonthName");
        field.setAccessible(true);

        try
        {
            TextView tv = (TextView) field.get(cv);
            tv.setTextColor(Color.RED);
        } 
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
    catch (NoSuchFieldException e)
    {
        e.printStackTrace();
    }