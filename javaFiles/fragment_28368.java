@RequestMapping(method = { RequestMethod.GET }, value = { "/downloadCsv" })
public ResponseEntity<InputStreamResource>  downloadCSV()
{
    try
    {
            String fileName = "test.csv";
            //Create here your CSV file
            File theCsv = new File(fileName);
            HttpHeaders respHeaders = new HttpHeaders();
            MediaType mediaType = new MediaType("text","csv");
            respHeaders.setContentType(mediaType);
            respHeaders.setContentDispositionFormData("attachment", fileName);
            InputStreamResource isr = new InputStreamResource(new FileInputStream(theCsv));
            return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
    }
    catch (Exception e)
    {
        String messagge = "Error in CSV creation; "+e.getMessage();
        logger.error(messagge, e);
        return new ResponseEntity<InputStreamResource>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}