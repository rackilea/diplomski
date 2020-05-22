public Rehearsal(int d, int m, int y) {
    try {
        sdf = new SimpleDateFormat("d-M-yyyy");
        sdf.setLenient(false);
        sdf.parse(d + "-" + m + "-" + y);
    } catch (ParseException e) {
        // the parameters are not valid
        throw new IllegalArgumentException();
    }
    day = d;
    month = m;
    year = y;
}