String inputPattern = "yyyy-MM-dd hh:mm:ss";
    String outputPattern = "dd-MMM-yyyy   hh:mm a";
    SimpleDateFormat inFormat = new SimpleDateFormat(inputPattern);
    SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

    Date date1 = null;

    if (date != null) {
        try {
            date1 = inFormat.parse(date);
            str = outputFormat.format(date1);
            Log.d(null, str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    } else {
        str = " ";
    }