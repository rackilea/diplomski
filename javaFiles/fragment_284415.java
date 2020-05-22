try {
    Calendar past = new GregorianCalendar();
    Calendar present = Calendar.getInstance();
    past.setTime(new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(birthDate));
    age = present.get(Calendar.YEAR) - past.get(Calendar.YEAR); 
} catch (ParseException e) {
    throw new InvalidDateFormatException("invalid date: " + birthDate);
}