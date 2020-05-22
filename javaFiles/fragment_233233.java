@RequestMapping(
    value = "/changeXML",
    params= {"configFile"},
    produces = {MediaType.TEXT_PLAIN}, // Change this
    headers = "Accept=application/xml", 
    method = RequestMethod.GET)