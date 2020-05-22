@RequestMapping(value = "/reports/fullreport/pdf", method = RequestMethod.GET)
@ResponseBody
public Object fullReport(HttpServletResponse response){

        JRPdfExporter exporter = JasperFillManager.fillReport(jasperReport, parameters, customDataSource; //the function prepares the PDF repport

        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "attachment; filename=" + filename + ".pdf");

        final OutputStream outStream = response.getOutputStream();
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
        exporter.exportReport();

        return null;