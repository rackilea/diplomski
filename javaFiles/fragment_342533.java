@RequestMapping(value = "/foo", method = RequestMethod.GET)
public String fooMethod(HttpServletRequest request) {
    String path = request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
    System.out.println("path foo: " + path);
    return "bar";
}