private static final String sourceFormat = "HH:mm:ss";
    private static final String targetFormat = "hh:mm a";

public static String convertTimeFormat(String dateStr)  {

        if (dateStr.equals("")) {
            return "";
        }
        Log.d("date", dateStr + "---" + sourceFormat + "---" + targetFormat);

        **SimpleDateFormat form = new SimpleDateFormat(sourceFormat, Locale.US);**


        Date date = null;
        try {
            date = form.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        **SimpleDateFormat postFormater = new SimpleDateFormat(targetFormat, Locale.US);**

        String newDateStr = postFormater.format(date);
       Log.d("Lead Response", newDateStr);
        return newDateStr;
    }