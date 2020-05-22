Calendar currentDate = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");


    String dateNow = sdf.format(currentDate.getTime());
      Date today =  new Date(dateNow);
      Date finalDay = null;
      finalDay = (Date) sdf.parse("MM/dd/yyyy");
    int numberOfDays=(int)((finalDay.getTime()-today.getTime())/(3600*24*1000));