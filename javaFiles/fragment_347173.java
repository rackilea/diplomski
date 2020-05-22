enum Zodiac {
    Aries("March 21", "April 19");

    LocalDate begin, end;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM DD");

    Zodiac(String begin, String end){
        this.begin = LocalDate.parse(begin, dtf);
        this.end = LocalDate.parse(end, dtf);
    }

    public int compareToOtherZodiac(Zodiac o) {
        return this.begin.compareTo(o.begin);
    }
}