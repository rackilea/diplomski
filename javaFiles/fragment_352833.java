@RequestMapping(value="/**", method = RequestMethod.GET)
public String get(HttpServletRequest request) throws Exception {
    String dynPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    System.out.println("Dynamic Path: " + dynPath );
    return dynPath;
}