@Controller 
@RequestMapping("/report") 
public class RaporController { 

    @GetMapping() 
    public ResponseEntity reporting(Model model, HttpServletResponse response) throws IOException { 
        JasperPrint jasperPrint = reportService.report(new Date(), sqlTable, false); 
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, out);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData(reportService.getFilename(), reportService.getFilename());
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity(out.toByteArray(), headers, HttpStatus.OK);
     }
}