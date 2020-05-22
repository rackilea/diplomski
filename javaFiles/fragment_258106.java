class MonthInterval {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    LocalDateTime monthBegin, monthEnd;

    public MonthInterval(LocalDateTime monthBegin, LocalDateTime monthEnd) {
        this.monthBegin = monthBegin;
        this.monthEnd = monthEnd;
    }

    @Override
    public String toString() {
        return monthBegin.format(formatter) + " > " + monthEnd.format(formatter);
    }
}