long MILLIS_IN_DAY = 1000 * 60 * 60 * 24;

        String lastEvent =  "13.07.2013 10:20:06";
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        Date lastEventDate = sdf.parse(lastEvent);
        Date currentDate = new Date();

        long timeElapsed = currentDate.getTime() - lastEventDate.getTime();
        long diffInDays = timeElapsed / MILLIS_IN_DAY; 

        System.out.println(diffInDays);