try
{
    AccessController.doPrivileged(new PrivilegedAction()
    {
        public Object run()
        {
            try
            {
                // privileged code goes here, for example:
                System.load("C:/Program Files/.../Mydll.dll");
                return null; // nothing to return
            }
            catch (Exception e)
            {
                System.out.println("Unable to load Mydll");
                return null;
            }
        }
     });
}
catch (Exception e)
{
    System.out.println("Unable to load Mydll");
}