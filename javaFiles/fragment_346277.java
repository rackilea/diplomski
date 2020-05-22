Date d1 = null;
Date d2 = null;
    try {
        d1 = Date.getInstance();
        d2 = format.parse(file2.getName());
    } catch (ParseException e) {
        e.printStackTrace();
    }    

    long diff = d2.getTime() - d1.getTime();
    long diffDays = diff / (60 * 60 * 1000 * 24);
    if(diffDays<=-3)
    {
        // Your code of delete
    }