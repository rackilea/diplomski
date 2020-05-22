public interface Shell32 extends StdCallLibrary {
    final static Map<String, Object> WIN32API_OPTIONS = new HashMap<String, Object>() {
        private static final long serialVersionUID = 1L;
        {
            put(Library.OPTION_FUNCTION_MAPPER, W32APIFunctionMapper.UNICODE);
            put(Library.OPTION_TYPE_MAPPER, W32APITypeMapper.UNICODE);
        }
    };

    public Shell32 INSTANCE = (Shell32) Native.loadLibrary("Shell32", Shell32.class, WIN32API_OPTIONS);

    //whatever you want to expose here
}