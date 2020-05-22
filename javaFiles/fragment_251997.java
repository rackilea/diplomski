public class Info {

    public String imei;
    public Integer delta;

    public Info(String imei) {
        this.imei = imei;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Info && obj.imei.equals(imei);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[] { imei });
    }

}