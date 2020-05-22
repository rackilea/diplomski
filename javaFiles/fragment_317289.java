private final static Pattern debugPattern = Pattern.compile("-Xdebug|jdwp");
public static boolean isDebugging() {
    for (String arg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
        if (debugPattern.matcher(arg).find()) {
            return true;
        }
    }
    return false;
}