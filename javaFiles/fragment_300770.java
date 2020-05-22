@RequestMapping(value="/echoRequest")
public @ResponseBody String echoRequest(HttpEntity<String> httpEntity, HttpServletRequest req) {
    String out = "";
    List<String> names = req.getHeaderNames();
    for (String name : names) {
        out += (name + ": " + req.getHeader(name) + "\n");
    }
    if (httpEntity.hasBody()) {
        out += httpEntity.getBody();
    }
    return out;
}