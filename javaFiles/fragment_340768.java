HttpServletResponse servletResponse = ctx.getResponse();

  ...

String updatedResponse = jsonObj.toString();
try {
    OutputStream outStream = servletResponse.getOutputStream();
    outStream.write(updatedResponse.getBytes(), 0, updatedResponse.length());
    outStream.flush();
    outStream.close();
} catch (IOException e) {
    log.warn("Error reading body", e);
}