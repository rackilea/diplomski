import java.lang.management.ManagementFactory;
import sun.jvmstat.monitor.MonitoredVmUtil;
import sun.jvmstat.monitor.VmIdentifier;
import sun.jvmstat.perfdata.monitor.protocol.local.LocalMonitoredVm;

...

public static String jvmstatMainClass() {
    // Determine the VMID (on most platforms, this will be the PID)
    final String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];

    // Connect to the virtual machine by VMID
    final VmIdentifier vmId = new VmIdentifier(pid);
    final LocalMonitoredVm lmVm = new LocalMonitoredVm(vmId, 1000);

    // Find the requested main-class
    String mainClass = MonitoredVmUtil.mainClass(lmVm, true);

    // And detach from the VM
    lmVm.detach();

    return mainClass;
}