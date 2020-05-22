@RequestMapping(value = "/modules/{moduleBaseName}/**", method = RequestMethod.GET)
@ResponseBody
public String moduleStrings(@PathVariable String moduleBaseName, HttpServletRequest request) {
    final String path =
            request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
    final String bestMatchingPattern =
            request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();

    String arguments = new AntPathMatcher().extractPathWithinPattern(bestMatchingPattern, path);

    String moduleName;
    if (null != arguments && !arguments.isEmpty()) {
        moduleName = moduleBaseName + '/' + arguments;
    } else {
        moduleName = moduleBaseName;
    }

    return "module name is: " + moduleName;
}