public interface Aura extends StdCallLibrary {

    Aura INSTANCE = Native.loadLibrary("AURA_SDK", Aura.class, W32APIOptions.DEFAULT_OPTIONS);

    public static class MbLightControl extends WinDef.PVOID {}

    public int EnumerateMbController(MbLightControl[] handles, int size);
    public int SetMbMode(MbLightControl handle, int mode);
    public int SetMbColor(MbLightControl handle, byte[] color, int size);
    public int GetMbColor(MbLightControl handle, byte[] color, int size);
    public int GetMbLedCount(MbLightControl handle);
}