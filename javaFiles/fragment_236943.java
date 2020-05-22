public class Bar {

    private String m_time;
    private double m_open;
    private double m_high;
    private double m_low;
    private double m_close;
    private long m_volume;
    private int m_count;
    private double m_wap;

    public Bar(String m_time, double m_open, double m_high, double m_low, double m_close, long m_volume, int m_count, double m_wap) {
        this.m_time = m_time;
        this.m_open = m_open;
        this.m_high = m_high;
        this.m_low = m_low;
        this.m_close = m_close;
        this.m_volume = m_volume;
        this.m_count = m_count;
        this.m_wap = m_wap;
    }

    public String time() {
        return m_time;
    }

    public double open() {
        return m_open;
    }

    public double high() {
        return m_high;
    }

    public double low() {
        return m_low;
    }

    public double close() {
        return m_close;
    }

    public long volume() {
        return m_volume;
    }

    public int count() {
        return m_count;
    }

    public double wap() {
        return m_wap;
    }

}