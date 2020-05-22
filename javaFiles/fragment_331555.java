public abstract class UiCodeHolder {
    static ThreadLocal<UiCodeDto> current = new ThreadLocal<>()

    public void set(UiCodeDto uiCode) {
        current.set(uiCode);
    }

    public UiCodeDta get() {
        return current.get();
    }

    public void clear() {
        current.remove(); // for older versions use current.set(null);
    }
}