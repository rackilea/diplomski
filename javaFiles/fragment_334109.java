@RequestMapping("/workingController")
public void workingController(
        @RequestParam(value = "A", required = true) String A,
        @RequestParam(value = "B", required = false) Boolean B,
        @RequestParam(value = "format", required = false, defaultValue = "json") String format,
        HttpServletResponse response)
        throws IOException
{
    String applicationType = "application/json";

    if (format.equals("xml"))
    {
        applicationType = "text/xml";
    }

    String aResponse = new RestTemplate().getForObject(
            "http://{host}:{port}/{appName}/controllerExternal?A={A}&B={B}&format={format}",
            String.class, A, B, format);
    response.setContentType(applicationType);
    response.setContentLength(aResponse.length());
    response.getOutputStream().write(aResponse.getBytes());
    response.getOutputStream().flush();
}