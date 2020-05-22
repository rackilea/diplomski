MonitoredHost monitoredHost = MonitoredHost.getMonitoredHost("//localhost");

List<MonitoredVm> monitoredVms = new ArrayList<MonitoredVm>();
Set<Integer> vms = monitoredHost.activeVms();
for (Integer vm : vms) {
   monitoredVms.add(monitoredHost.getMonitoredVm(new VmIdentifier(vm.toString())));
}        

for (MonitoredVm monitoredVm : monitoredVms) {
   System.out.println(MonitoredVmUtil.commandLine(monitoredVm))
}