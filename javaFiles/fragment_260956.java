public static boolean isWithingSH(Date startSH, Date now, Date stopSH) {
    try {
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm", Locale.UK);
        Date startTime = parser.parse(startSH.getHours() + ":" + startSH.getMinutes());
        Date endTime = parser.parse(stopSH.getHours() + ":" + stopSH.getMinutes());
        Date nowTime = parser.parse(now.getHours() + ":" + now.getMinutes());

        if(startTime.after(endTime)) {
            if(endTime.after(nowTime)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (startTime.before(nowTime) && endTime.after(nowTime)){
                return true;
            } else {
                return false;
            }
        }
    } catch (java.text.ParseException e) {
        return false;
    }
}