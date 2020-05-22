@Controller
public class TestController {
    @RequestMapping(value = "/test", method = POST, produces = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity<String> sendMessage(HttpSession session, @RequestParam String intxnId, @RequestParam String message, HttpServletRequest request, HttpServletResponse response) {

        System.out.println("Send Message UTF-8 ----------------- " + message);

        String json = null;
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("name", "test");
        result.put("message", message);
        result.put("time", "time");
        ObjectMapper map = new ObjectMapper();
        if (!result.isEmpty()) {
            try {
                json = map.writeValueAsString(result);
                System.out.println("Send Message  :::::::: : " + json);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        HttpHeaders responseHeaders = new HttpHeaders(); 
        responseHeaders.add("Content-Type", "application/json; charset=utf-8"); 
        return new ResponseEntity<String>(json, responseHeaders, HttpStatus.CREATED);
    }
}