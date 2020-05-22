public class LaunchServlet extends HttpServlet
  {
    private static final long serialVersionUID = 4277145689972356257L;
        //this method is run as tomcat starts up this servlet
    public void init() throws ServletException
   {
        try
        {
            System.out.println("Launching my application...");
            new Thread(new ApplicationLauncher()).start();
            System.out.println("Launched my application successfully. ");
        }
        catch(Exception e)
        {
           throw new RuntimeException("Fail Fast: Unable to launch exception.");
        }
    }

      class ApplicationLauncher implements Runnable
      {
      public void run()
       {
              //start you applicaton here
        }

      }

    }