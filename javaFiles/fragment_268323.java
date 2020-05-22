public static class Info {
    public final String time;
    public final int frq;
    public final String mod;
    public final String lat;
    public final String lon;
    public final String alt;
    public final String wifi;
    public final String mac;
    public final String signal;

    public Info(String[] column, String mod) {
        time = column[3];
        this.mod = mod;
        lat = column[6];
        lon = column[7];
        alt = column[8];
        wifi = column[1];
        mac = column[0];
        frq = Integer.parseInt(column[4]);
        signal = column[5];
    }
}