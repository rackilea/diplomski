FunctionMapper mapper = new FunctionMapper() {
    public String getFunctionName(NativeLibrary library, Method method) {
    if (Platform.isWindows()) {
        if (method.getName().equals("rocket")) {
            return "Rocket";
        }
    }
    return method.getName();