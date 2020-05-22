private ObjectMapper mapper = new ObjectMapper();

@RequestMapping(value = "/getStuff", method = RequestMethod.GET)
public void getStuff(HttpServletResponse httpServletResponse) throws Exception {
    try {
        httpServletResponse.setHeader("Pragma","public");
        httpServletResponse.setHeader("Expires","0");
        httpServletResponse.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
        httpServletResponse.setHeader("Cache-Control","public");
        OutputStream outputStream = httpServletResponse.getOutputStream();
        try {
            mapper.writeValue(outputStream, myObject);
        } finally {
            outputStream.close();
        }