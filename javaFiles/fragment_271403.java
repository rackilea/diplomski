public class SwitchPerspectiveAction extends Action {

    public void run() {
        if (PlatformUI.getWorkbench() != null) {
            try {
                IPerspectiveDescriptor descriptor = window.getWorkbench()
                    .getPerspectiveRegistry()
                    .findPerspectiveWithId(Perspective.ID);

                PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                    .getActivePage().setPerspective(descriptor);

            } catch (WorkbenchException e) {
                e.printStackTrace();
            }
        }
    }   
}