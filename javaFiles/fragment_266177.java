try {
        DateFormat f = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        Date d = f.parse("8/29/2011 11:16:12 AM");
        DateFormat date = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat time = new SimpleDateFormat("hh:mm:ss a");
        System.out.println("Date: " + date.format(d));
        System.out.println("Time: " + time.format(d));
    } catch (ParseException e) {
        e.printStackTrace();
    }