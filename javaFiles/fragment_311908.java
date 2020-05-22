public interface User32 extends StdCallLibrary {
    ...
    public static final int SM_CXSCREEN = 0x0;
    public static final int SM_CYSCREEN = 0x1;
    int GetSystemMetrics(int index);
}

public static void main(String[] args) {    
    ...
    input.input.setType("mi");
    input.input.mi.dx = new LONG(500 * 65536 / User32.INSTANCE.GetSystemMetrics(User32.SM_CXSCREEN));
    input.input.mi.dy = new LONG(500 * 65536 / User32.INSTANCE.GetSystemMetrics(User32.SM_CYSCREEN));
    ...
}