try{
        String dataFormatOrigin = "Wed Jun 01 14:12:42 2011";
        // this is original string with the date information 
        SimpleDateFormat sdfSource = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy", Locale.US);

        Date date = sdfSource.parse(dataFormatOrigin);

        // (01/06/2011 14:12:42) - the destination format that I want to have 
        SimpleDateFormat sdfDestination = new SimpleDateFormat( "dd-MM-yyyy hh:mm:ss");

        String dataFormatDest = sdfDestination.format(date);

        System.out .println("Date is converted to MM-dd-yyyy hh:mm:ss"); System.out .println("Converted date is : " + dataFormatDest);

    } catch (ParseException pe) { 
        System.out.println("Parse Exception : " + pe); 
        pe.printStackTrace();
    }