@PostMapping("/view/**")
public ModelAndView view(HttpServletRequest request) {
    String pathVariable = extractId(request);         

    ModelAndView modelAndView = new ModelAndView();
    return modelAndView;
}

private String extractId(HttpServletRequest request) {
    String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
    String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
    return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
}