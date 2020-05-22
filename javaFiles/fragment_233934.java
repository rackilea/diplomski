public class Where
   {
   /**
    * main
    * @param args name of fully qualified class to find, using dots, but no dot class.
    * e.g. java.exe Where javax.mail.internet.MimeMessage
     */
   public static void main ( String[] args )
      {
      try
         {
         String qualifiedClassName = args[0];
         Class qc = Class.forName( qualifiedClassName );
         CodeSource source = qc.getProtectionDomain().getCodeSource();
         if ( source != null )
            {
            URL location = source.getLocation();
            System.out.println ( qualifiedClassName + " : " + location );
            }
         else
            {
            System.out.println ( qualifiedClassName + " : " + "unknown source, likely rt.jar" );
            }
         }
      catch ( Exception e )
         {
         System.err.println( "Unable to locate class on command line." );
         e.printStackTrace();
         }
      }
   }