enum Zodiac {
    Aries("March 21", "April 19");

    Date begin, end;
    DateFormat dtf = new SimpleDateFormat("MMMM DD");

    Zodiac(String begin, String end) {
        try {
            this.begin = dtf.parse(begin);
            this.end = dtf.parse(end);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    public int compareToOtherZodiac(Zodiac o) {
        return this.begin.compareTo(o.begin);
    }
}