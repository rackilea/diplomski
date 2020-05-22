Date dateObj = null;
try {
    dateObj = curFormater.parse(InitialDate);
} catch (ParseException e) {
    e.printStackTrace();
}