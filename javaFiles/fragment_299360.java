String TRANSACTION_URL = "http://mon.vip.host.com/reports/podding/Transaction?&defaultDim=Name&defaultDim=Type&metric=TransactionDuration&percentile=95";

    Calendar startDate = new GregorianCalendar();
    startDate.set(Calendar.MINUTE,0);
    Calendar endDate =(Calendar) startDate.clone();
    startDate.set(Calendar.HOUR_OF_DAY,0);

    DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    String startTime = df.format(startDate.getTime());
    String endTime = df.format(endDate.getTime());

    System.out.println(TRANSACTION_URL+"&startTime="+startTime+"&endTime="+endTime);