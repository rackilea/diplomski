@Controller
@RequestMapping("/generateReport.do")
public class ReportController

    @RequestMapping(method = RequestMethod.POST)
    public void generateReport(HttpServletResponse response) throws Exception {

        byte[] data = //read PDF as byte stream

        streamReport(response, data, "my_report.pdf"));
    }

    protected void streamReport(HttpServletResponse response, byte[] data, String name)
            throws IOException {

        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=" + name);
        response.setContentLength(data.length);

        response.getOutputStream().write(data);
        response.getOutputStream().flush();
    }
}