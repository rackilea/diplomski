try {
        //parsing date format
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        String dealDateString = "02-Mar-2015";
        Date date = formatter.parse(dealDateString);
        TimeZone tz = TimeZone.getDefault();

        //converting date format for US
        SimpleDateFormat sdfAmerica = new SimpleDateFormat("MM/dd/yyyy");
        TimeZone tzInAmerica = TimeZone.getTimeZone("America/New_York");
        sdfAmerica.setTimeZone(tzInAmerica);

        String sDateInAmerica = sdfAmerica.format(date); // Convert to String first
        System.out.println("Date (String) : " + sDateInAmerica);

    } catch (Exception bug) {
        bug.printStackTrace();
    }