public class Writer {

     private static Logger logger = Logger.getLogger("service");
         /**
          * Writes the report to the output stream
          */
         public static void write(HttpServletResponse response, HSSFSheet worksheet) {

          logger.debug("Writing excel data to the stream");
              try {
                   // Retrieve the output stream
                   ServletOutputStream outputStream = response.getOutputStream();
                   // Write to the output stream
                   worksheet.getWorkbook().write(outputStream);
                   // Flush the stream
                   outputStream.flush();
              } 
              catch (Exception e) {
                  logger.error("Unable to write excel data to the output stream");
              }
     }
}