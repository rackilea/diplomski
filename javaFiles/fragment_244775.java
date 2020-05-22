List<Date> dates = new ArrayList<Date>();
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(dateChkIn);

    Date result = null;
    while (calendar.getTime().before(dateChkOut)){
            result = calendar.getTime();


            dates.add(result);
            calendar.add(Calendar.DATE, 1);
    }
    System.out.println("DAYS CALCULATED BY NEW SOLUTION: " + dates.size());
    newNumberOfNghtsCalc = (long) dates.size();
    dates.clear();