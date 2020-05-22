private int timeToMs(Time t) {
    return t.getHH() * 60 * 60 * 1000 + t.getMM() * 60 * 1000 + t.getSS() * 1000 + t.getMS();
}

private int findOffset(Time begin, Time end) {
    return timeToMs(end) - timeToMs(begin);
}