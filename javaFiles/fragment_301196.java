String theTime = "23:55";

    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm"); //HH = 24h format
    dateFormat.setLenient(false); //this will not enable 25:67 for example
    try {
        System.out.println(dateFormat.parse(theTime));
    } catch (ParseException e) {
        throw new RuntimeException("Invalid time "+theTime, e);
    }