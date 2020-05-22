public class DeviceParameters extends Structure {
    public ByValue extends DeviceParameters implements Structure.ByValue {
        public ByValue() { }
        public ByValue(Pointer p) { super(p); read(); }
    }
}