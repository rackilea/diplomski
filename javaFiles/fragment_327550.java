// Checking for local Host, one can do for remote machine as well
MonitoredHost local = MonitoredHost.getMonitoredHost("localhost");
// Take all active VM's on Host, LocalHost here
Set<Integer> vmlist = new HashSet<>(local.activeVms());
for (Integer id : vmlist) {
    // 1234 - Specifies the Java Virtual Machine identified by lvmid 1234 
    // on an unnamed host. This string is transformed into the absolute 
    // form //1234, which must be resolved against a HostIdentifier.
    MonitoredVm vm = local.getMonitoredVm(new VmIdentifier(String.format("//%d", id)));
    // take care of class file and jar file both
    String processname = MonitoredVmUtil.mainClass(vm, true);
    System.out.printf("%d: %s%n", id, processname);
}