Date startTime = ...//start
    Date endTime = ../end
    ArrayList<String> times = new ArrayList<String>();
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    Calendar calendar = GregorianCalendar.getInstance();
    calendar.setTime(startTime);
    while(calendar.getTime().before(endTime)) {
         calendar.add(Calendar.MINUTE, 30);
         times.add(sdf.format(calendar.getTime()));
    }