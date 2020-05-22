FunctionMapper mapper = new FunctionMapper() {
    public String getFunctionName(NativeLibrary library, java.lang.reflect.Method method) {
        String name = method.getName();
        try {
            library.getFunction(name);
        } catch(UnsatisfiedLinkError e) {
            try {
                library.getFunction(name + "64");
                return name + "64";
            } catch(UnsatisfiedLinkError e) {
                 // If neither variant worked, report failure on the base label
            }
        }
        return name;
    }
};
Map options = new HashMap() {
    { put(Library.OPTION_FUNCTION_MAPPER, mapper); }
};
library = Native.loadLibrary("c", options);