String dateString = "06/19/2015";
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    Calendar c = Calendar.getInstance();
    try {
        Date date1 = sdf.parse(dateString);
        //makes sense using calendar only if you want to process the date fields
        //otherwise use if (new Date().before(date1)){...}
        if (c.getTime().before(date1)) {
            System.out.println("Victory!");
        };

        date1.getTime();
    } catch (ParseException e) {
        System.out.println("Invalid date format");
    }