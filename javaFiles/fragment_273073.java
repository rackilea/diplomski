public static final String TIME_STAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {

        Date standard = getStandardDate();
        SimpleDateFormat format = new SimpleDateFormat(TIME_STAMP_FORMAT);

        List<String> data = new ArrayList<String>();
        data.add("2015-09-22 08:59:59");
        data.add("2015-09-22 09:00:00");
        data.add("2015-09-22 09:00:01");

        for (String date : data) {
            if(isLate(date, format)) {
                System.out.println(date + " is Late");
            } else {
                System.out.println(date + " is On Time");
            }
        }

    }

    /**
     * check is Late or not
     * */
    public static boolean isLate(String date, SimpleDateFormat format) {
        Date standard = getStandardDate();
        Date inputDate = null;
        boolean result = false;
        try {
            inputDate = format.parse(date);
            if(inputDate.after(standard)) {
                result = true;
            } 
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * get standard date
     * */
    public static Date getStandardDate() {
        Date dateNow = new Date ();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateNow);
        cal.set(Calendar.DAY_OF_MONTH, 22);
        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }