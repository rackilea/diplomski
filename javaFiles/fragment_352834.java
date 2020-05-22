@RequestMapping(value="/{path1}/{path2}/**", method = RequestMethod.GET)
public String get(@PathVariable("path1") String path1,
          @PathVariable("path2") String path2,
          HttpServletRequest request) throws Exception {
    String dynPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    System.out.println("Dynamic Path: " + dynPath );
    return dynPath;
}