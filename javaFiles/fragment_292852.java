@GetMapping("/stub_mapping_template")
    public FileSystemResource getMappingTemplate(HttpServletResponse response) {
      ClassPathResource classPathResource = new ClassPathResource("/stub/mapping_template.csv");
      File file = classPathResource.getFile();

      InputStream in = new FileInputStream(file);

      response.setContentType(....);
      response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
      response.setHeader("Content-Length", String.valueOf(file.length()));
      FileCopyUtils.copy(in, response.getOutputStream());
      response.flushBuffer();
}