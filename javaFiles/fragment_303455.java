private void time() {
    int day = 0;
    Date now = new Date();
    String sdf = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(now);

    switch (sdf) {

        case ("Monday"):
            day = 1;
            break;
        case ("Tuesday"):
            day = 2;
            break;
        case ("Wednesday"):
            day = 3;
            break;
        case ("Thursday"):
            day = 4;
            break;
        case ("Friday"):
            day = 5;
            break;
        case ("Saturday"):
            day = 6;
            break;
        case ("Sunday"):
            day = 7;
            break;
    }

    int mm = Calendar.getInstance().get(Calendar.MINUTE);
    int HH = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    int dd = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    int MM = Calendar.getInstance().get(Calendar.MONTH)+1;
    int yy = Calendar.getInstance().get(Calendar.YEAR)%100;


    String A = "A";
    String min = String.format("%02d",mm);
    String hour = String.format("%02d",HH);
    String d = String.format("%02d",day);
    String date = String.format("%02d",dd);
    String month = String.format("%02d",MM);
    String year = String.format("%02d",yy);
    String B = "B";

    String time2 = A+min+hour+d+date+month+year+B;
    sendMessage(time2);
}