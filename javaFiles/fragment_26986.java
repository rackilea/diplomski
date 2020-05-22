private Calendar convertToCalender(String date) {
        Calendar mCalender = Calendar.getInstance();
        if (date == null) {
            return mCalender;
        } else {
            try {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date returnDate = formatter.parse(date);
                mCalender = Calendar.getInstance();
                mCalender.setTime(returnDate);
                return mCalender;
            } catch (ParseException e) {
                e.printStackTrace();
                return mCalender;
            }
        }
}