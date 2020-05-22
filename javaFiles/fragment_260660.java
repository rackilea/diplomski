try (OutputStream out = response.getOutputStream()) {
    byte[] image = ...
    response.setContentLength(image.length);
    response.setContentType("image/png"); //or something more generic...
    response.setHeader("Accept-Ranges", "bytes");
    response.setStatus(HttpServletResponse.SC_OK);

    out.write(image);
}