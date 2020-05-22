@RequestMapping(value = "/downloadResolution/{resolutionId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
public void downloadResolution(@PathVariable("resolutionId") Long resolutionId, HttpServletResponse response) throws IOException {
    String test = "new string test bytes";
    response.setHeader("Content-Disposition", "attachment; filename=file.txt");
    response.getOutputStream().write(test.getBytes());
}