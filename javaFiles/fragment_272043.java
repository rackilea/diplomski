private String suffix(Period p) {
    int days = p.getDays();
    if (days <= 0) {
        return "";
    }

    return days == 1 ? "day" : "days";
}