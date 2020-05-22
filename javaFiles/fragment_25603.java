String startDateString = "16/02/2006";

SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
Date date = simpleDateFormat.parse(startDateString);
Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
if (calendar.get(Calendar.YEAR) < 2006) {
    // code here
}