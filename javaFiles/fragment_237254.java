@RequestMapping(value = "/pdf-report/{id}.pdf", method = RequestMethod.GET)
public void downloadPdfReport(@PathVariable String id, HttpServletRequest req, HttpServletResponse resp) throws Exception {

    //supposed logic here
    //if we are failing here then
    throw new UserFriendlyException("Cannot produce data");
}