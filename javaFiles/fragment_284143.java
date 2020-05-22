@GetMapping(value = "/docs/{filename}")
 public void download(@Pathvariable filename) {
    FileSystemResource file = new FileSystemResource(fileservice.resolve(filename));
    rsp.setHeader("Content-Disposition", "attachment; filename=" + file.getFilename());

    ResourceHttpMessageConverter handler = new ResourceHttpMessageConverter();
    handler.write(file, MediaType.APPLICATION_OCTET_STREAM, new ServletServerHttpResponse(rsp));
 }