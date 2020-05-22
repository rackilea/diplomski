@Controller
class ReportController{

   //1- Method for JSON/marshalling types(XML)
    @RequestMapping(value="/report", produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<ReportPara> generateReport(Principal principal) {
        return reportService.generateReport(principal);
    }

    //2- For View technologies ( Eg:JSP HTML)
    @RequestMapping("/report")
    public String generateReportForView(Model model, Principal principal) {
        model.addAttribute( generateReport(principal) );

        // Return the view to use for rendering the response
        return ¨reports/main¨;
    }
}