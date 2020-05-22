public interface PcShll32 extends StdCallLibrary { //StdCallLibrary is for Windows functions

    PcShll32 INSTANCE = (PcShll32) Native.loadLibrary(
                   "pcshll32", PcShll32.class, W32APIOptions.DEFAULT_OPTIONS); //Options are for Win32API

    // your methods
}