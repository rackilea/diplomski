RuntimeMXBean RuntimemxBean = ManagementFactory.getRuntimeMXBean();
List<String> args = RuntimemxBean.getInputArguments();
for (String arg : args) {
    if (arg.contains("-javaagent:")) {
        // block application from running
    }
}