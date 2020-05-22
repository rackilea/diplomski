Collections.sort(dates, (d1, d2) -> {
    if (d1.after(now) && d2.after(now)) {
        return d1.compareTo(d2);
    }
    if (d1.before(now) && d2.before(now)) {
        return -d1.compareTo(d2);
    }
    return -d1.compareTo(d2);
});