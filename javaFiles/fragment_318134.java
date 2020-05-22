@RestController
public class XlsxController {

    @RequestMapping(path = "/download/xls", method = RequestMethod.GET, produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public void downloadXls(HttpServletResponse r) throws IOException {
        r.setHeader("Content-Description", "File Transfer");
        r.setHeader("Content-Disposition", "attachment; filename=justAFile.xlsx");
        r.setHeader("Content-Transfer-Encoding", "binary");
        r.setHeader("Connection", "Keep-Alive");

        try (SXSSFWorkbook w = getWorkbook()) {
            w.write(r.getOutputStream());
        }
    }