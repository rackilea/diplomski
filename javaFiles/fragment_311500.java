static SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zZ yyyy", Locale.US);
static SimpleDateFormat outputFormatTime = new SimpleDateFormat("HH:mm:ss");

public static String convertUtcDateStringToTime(String utcDateValue) throws Exception
    {
        Date parsedDate = dateFormat.parse(utcDateValue);
        String returnDate=outputFormatTime.format(inputFormat);
        return returnDate;
    }