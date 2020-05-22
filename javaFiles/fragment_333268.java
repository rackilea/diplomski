public class Application implements IApplication
{
  @Override
  public Object start(final IApplicationContext context)
  {
    final Display display = PlatformUI.createDisplay();
    try
     {
       final int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
       if (returnCode == PlatformUI.RETURN_RESTART)
         return IApplication.EXIT_RESTART;

        return IApplication.EXIT_OK;
     }
    finally
     {
       display.dispose();
     }
  }