@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public List<Template> getTemplatesJson(HttpServletResponse response) {
    logger.info("GET all computers- /computers/ -- content type = application/json");
    response.setHeader("Content-Disposition", "attachment; filename=templates.json");
    return computerService.retrieveAllComputers();
}