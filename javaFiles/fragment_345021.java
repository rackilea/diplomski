@RequestMapping(value = "/paths")
public class YourApplication
{
      @RequestMapping(value = "/pdf", method = RequestMethod.GET, produces = "application/pdf")
      public ResponseEntity<InputStreamResource> downloadPDFFile() throws IOException {
         // you code for pdf
      }

      @RequestMapping(value = "/xlsx", method = RequestMethod.GET, produces = "application/xlsx")
      public ResponseEntity<InputStreamResource> downloadXLSXFile() throws IOException {
         // you code for xlsx
      }
}