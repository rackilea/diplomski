@RestController
public class Controller {
    @RequestMapping(value="/convert/{format}", method=RequestMethod.POST)
    public @ResponseBody void convert(HttpServletRequest request, HttpServletResponse response, @PathVariable String format, @RequestParam Map<String, String> params) {
        try{
            if ("pdf".equalsIgnoreCase(format)) {
                PDFConverter cnv = new PDFConverter();
                response.setContentType("application/pdf");
                cnv.convert(request.getInputStream(), response.getOutputStream(), params);
            } else {
                // handle other formats
                throw new IllegalArgumentException("illegal format: " + format);
            }
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }
}