public class Widget {
    ... //assuming you have all the right fields here
    public Widget setSerialNumber(String id) {
        this.id = id;
        return this;
    }
    public Widget setArea(String area) {
        this.area = area;
        return this;
    }
    public static class Builder(){
        public Builder(String id) {...}
        public Builder serialNumber (String val) {...}
        public Builder area (String val) {...}
        public Widget build() { return new Widget(this); }
    }
    private Widget(Builder builder){...}
}