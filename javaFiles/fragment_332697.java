public Monitor getCurrentMonitor() {
    return monitors.stream()
                   .filter(a -> a.isCurrent())
                   .findFirst()
                   .orElseThrow(() -> new NoCurrentMonitorException());
}