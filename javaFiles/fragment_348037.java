public class VTermColor extends Union {
    public class RGB extends Structure {
        public byte type;
        public byte red;
        public byte green;
        public byte blue;
    }

    public class Indexed extends Structure {
        public byte type;
        public byte idx;
    }

    public byte type;
    public RGB rgb;
    public Indexed indexed;

    public VTermColor() {
        // initialize knowing only the type, read its value
        this.setType("type");
        this.read();

        // switch union based on type, re-read
        if ((this.type & VTERM_COLOR_TYPE_MASK) == VTERM_COLOR_RGB) {
            this.setType("rgb");
        } else {
            this.setType("indexed");
        }
        this.read();
    }

    public VTermColor(Pointer p) {
        super(p);
        // same remaining code as above
    }
}