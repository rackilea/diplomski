public class NativeCppAdapter {
    public native void testKickoffSoForPrint();

    public void locLoadLib() {
        String soLibName = "/tmp/libNativeCppAdapter.so";
        System.load(soLibName);
    }
}