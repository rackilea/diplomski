import org.virtualbox_5_1.IMachine;
import org.virtualbox_5_1.ISnapshot;
import org.virtualbox_5_1.IVirtualBox;
import org.virtualbox_5_1.VirtualBoxManager;

public class SnapshotList {

    private static void printChilds(ISnapshot snapshot) {
        System.out.println("\"" + snapshot.getName() + "\" {" + snapshot.getId() + "}");
        for (ISnapshot snapChild : snapshot.getChildren()) {
            printChilds(snapChild);
        }
    }

    public static void main(String[] args) {
        /*
         * WebServices info
         */
        String wsHost = "http://localhost:18083";
        String wsUser = "user";
        String wsPass = "password";

        if (args.length < 1 || args[0] == null || args[0].length() < 1) {
            System.err.println("Specify the VM name/UUID as first parameter");
            System.exit(1);
        }

        String vmName = args[0];

        VirtualBoxManager vboxManager = VirtualBoxManager.createInstance(null);
        vboxManager.connect(wsHost, wsUser, wsPass);

        try {
            IVirtualBox vbox = vboxManager.getVBox();
            IMachine vm = vbox.findMachine(vmName);
            if (vm.getSnapshotCount() < 1) {
                System.out.println("The machine + " + vmName + " has no snapshot");
                System.exit(0);
            }

            // The magic is here: null will give you the root snapshot
            printChilds(vm.findSnapshot(null));
        } finally {
            vboxManager.disconnect();
            vboxManager.cleanup();
        }
    }

}