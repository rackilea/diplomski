@RequestMapping(value = "/page/location/*.kml", method = RequestMethod.GET)
public void getKMLFile(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
    try {
        // Getting the filename (ie splitting off the /page/location/ part)
        String uri = httpRequest.getRequestURI();
        String[] parts = uri.split("/");
        String alais = parts[parts.length - 1];

        // Our app specific code finding the file from the db location 
        Resource resource = resourceService.getResourceByAlias(alais);
        File file = resource.getAbsFile();

        // Putting the file onto the httpResponse 
        InputStream is = new FileInputStream(file);
        IOUtils.copy(is, httpResponse.getOutputStream());
        httpResponse.flushBuffer();

    } catch (IOException e) {
        throw new RuntimeException("IOError writing file to output stream");
    }
}