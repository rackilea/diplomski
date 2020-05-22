private final AntPathMatcher antPathMatcher = new AntPathMatcher();

@RequestMapping(value = "/some/uri/with/wildcards/**", method = RequestMethod.PUT)
public ResponseEntity<String> someMethod(HttpServletRequest request) {
    String matched = antPathMatcher.extractPathWithinPattern(
            (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE), request.getPathInfo());
    // ugly parsing code to read the path variables, allowing for the optionality of the second one
    String foo = matched;
    String bar = null;
    String[] pathVariables = matched.split("/");
    if (pathVariables.length > 1) {
        foo = pathVariables[0];
        bar = pathVariables[1];
    }
    return new ResponseEntity<>(foo + " and " + (bar == null ? "<null>" : bar), HttpStatus.OK);
}