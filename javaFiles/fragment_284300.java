@RequestMapping(value = "/{fileName}/**", method = RequestMethod.GET, produces = { "application/json" })
public String jsonREST(HttpServletRequest request, @PathVariable String fileName) {
    String uri = request.getRequestURI();

    //Do your stuff here
}