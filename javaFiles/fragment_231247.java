DateFormat df = new SimpleDateFormat("MMddyyyy");
    Date currentDate = new Date();
    int dateFromScanner = 11192015;

    try {
        Date formattedDateFromScanner = df
                .parse(String.valueOf(dateFromScanner));

        if (formattedDateFromScanner.before(currentDate)) {
            // Do some stuff
        } else {
            System.out.println("This date has not yet passed.");
        }
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }