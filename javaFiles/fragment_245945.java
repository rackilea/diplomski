@RequestMapping("/user/{id}")
    public ModelAndView profileDisplay(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value="id", required=false) String id
    ) throws UnknownHostException, MongoException {
        ...
    }