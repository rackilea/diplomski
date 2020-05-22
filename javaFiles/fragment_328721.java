String dateString = "04 Nov 2016 16:30:07 +0300";

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss Z");
    Date date;
    try {
        date = dateFormat.parse(dateString);

        dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String formatedDate = dateFormat.format(date);

        Log.d("Date", formatedDate);

    } catch (ParseException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }