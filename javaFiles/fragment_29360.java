public class SomeClass 
{
      private static final DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

      //Static Initialization Blocks
      static{
           df.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
      }

      public static String toUTCDateString(Date date)
      {     
          return df.format(date);
      }

     /* more static methods */
}