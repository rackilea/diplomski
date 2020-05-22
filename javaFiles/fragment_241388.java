private static final String SYSTEM_PROPERTY_EXIT_CODE = "eclipse.exitcode";

int returnCode = PlatformUI.createAndRunWorkbench(display, advisor);

if (returnCode == PlatformUI.RETURN_RESTART)
 {
   // eclipse.exitcode system property may be set to re-launch
   if (IApplication.EXIT_RELAUNCH.equals(Integer.getInteger(SYSTEM_PROPERTY_EXIT_CODE)))
      return IApplication.EXIT_RELAUNCH;

   return IApplication.EXIT_RESTART;
 }

return IApplication.EXIT_OK;