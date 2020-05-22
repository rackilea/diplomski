@RequestMapping(value="/something/**", method=RequestMethod.GET)
public String handleRequest(HttpServletRequest request){
    String pattern = (String) request.getAttribute(
                     HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
    String path = new AntPathMatcher()
            .extractPathWithinPattern(pattern, request.getServletPath());

    path = path.replaceAll("%2F", "/");
    path = path.replaceAll("%2f", "/");

    StringTokenizer st = new StringTokenizer(path, "/");
    while (st.hasMoreElements()) {
        String token = st.nextToken();
        // ...
    }
}