String dateString = "03/26/2012 11:49:00 AM";
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
    Date convertedDate = new Date();
    try {
        convertedDate = dateFormat.parse(dateString);
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    System.out.println(convertedDate);