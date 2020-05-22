public class Time {



    private int sec;

    public Time() {
        sec = 0;
    }

    public Time(int sec) {
        System.out.println(Com.cnt.getAndIncrement());
        this.sec = sec;
    }
    public void set(int sec){
        this.sec = sec;
    }
    public void add(int sec) {
        this.sec += sec;
    }

    public void add(Time other) {
        this.sec += other.sec;
    }

    public int getSeconds() {
        return this.sec;
    }

    @Override
    public String toString() {
        if (this.sec < 3600)
            return String.format("%d:%02d", sec / 60, sec % 60);
        return String.format("%d:%02d:%02d", sec / 3600, (sec % 3600) / 60,
                sec % 60);
    }

    public static int parseTime(String str) throws NumberFormatException {

        try {
            String[] strs = str.split(":");
            if (strs.length == 1) {
                return Integer.parseInt(str);

            } else if (strs.length == 2) {
                return Integer.parseInt(strs[0]) * 60
                        + Integer.parseInt(strs[1]);
            } else {

                int h, m, s;

                h = Integer.parseInt(strs[0]);
                m = Integer.parseInt(strs[1]);
                s = Integer.parseInt(strs[2]);
                return 3600 * h + 60 * m + s;
            }

        } catch (NumberFormatException e) {
            throw e;
        }
    }
}