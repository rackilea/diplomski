Calendar calendar = GregorianCalendar.getInstance();
String randomDigits = String.format("%d%02d%05d", 
        calendar.get(Calendar.MONTH) + 1,
        calendar.get(Calendar.DAY_OF_MONTH),
        your_random_number_lower_100000
);