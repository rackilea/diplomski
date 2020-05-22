public interface User32 extends StdCallLibrary {
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class,
            new HashMap<Object, Object>() {
            {
                put(OPTION_TYPE_MAPPER, W32APITypeMapper.UNICODE);
                put(OPTION_FUNCTION_MAPPER, W32APIFunctionMapper.UNICODE);
            }
        });
        public static final int SPI_GETDESKWALLPAPER = 0x0073;
        public static final int SPI_GETSCREENSAVERRUNNING = 114;
        boolean SystemParametersInfo(
                int uiAction,
                int uiParam,
                Pointer pvParam,
                int fWinIni
        );
    }