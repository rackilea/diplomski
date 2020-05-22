private String formatDate(String dateString) {
        try {
            SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss" /* 10-Sep-2013 09:53:37*/);
            Date d = sd.parse(dateString);
            sd = new SimpleDateFormat("yyyy-MM-dd");
            return sd.format(d);
        } catch (ParseException e) {
        }
        return "";
    }