@RequestMapping(value = "/envoiBl/{noBl}/{anotherParam}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
@Timed
    public void envoiBlToClient(@PathVariable("noBl") noBl,@PathVariable("anotherParam") String anotherParam,
            HttpServletResponse response) throws Exception {