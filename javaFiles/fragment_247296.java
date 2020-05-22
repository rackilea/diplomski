public void download() throws IOException {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

    response.reset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
    response.setContentType("application/xml"); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ServletContext#getMimeType() for auto-detection based on filename.
    response.setHeader("Content-disposition", "attachment; filename=\"name.xml\""); // The Save As popup magic is done here. You can give it any filename you want, this only won't work in MSIE, it will use current request URL as filename instead.

    BufferedInputStream input = null;
    BufferedOutputStream output = null;

    try {
        input = new BufferedInputStream(getYourXmlAsInputStream());
        output = new BufferedOutputStream(response.getOutputStream());

        byte[] buffer = new byte[10240];
        for (int length; (length = input.read(buffer)) > 0;) {
            output.write(buffer, 0, length);
        }
    } finally {
        close(output);
        close(input);
    }

    facesContext.responseComplete(); // Important! Else JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
}