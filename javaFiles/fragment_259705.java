private String randomDataOfBirth(int yearStart, int yearEnd)
    {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(yearStart, yearEnd);
        gc.set(Calendar.YEAR, year);
         int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

            gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
            String date = null;
            if(gc.get(Calendar.MONTH) == 0)
            {
                 date = gc.get(Calendar.YEAR) + "-" + 1 + "-" + gc.get(Calendar.DAY_OF_MONTH);
            }else
            {
                 date = gc.get(Calendar.YEAR) + "-" + gc.get(Calendar.MONTH) + "-" + gc.get(Calendar.DAY_OF_MONTH);
            }
            return date;    
    }

    private int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }