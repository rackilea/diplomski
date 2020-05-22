@RequestMapping(value = "/download/attachment/{attachid}", method = RequestMethod.GET)
public void getAttachmentFromDatabase(@PathVariable("attachid") int attachid, HttpServletResponse response) {

  response.setContentType("application/octet-stream");
  GroupAttachments groupAttachments = this.groupAttachmentsService.getAttachmenById(attachid);
  Path path = groupAttachmetns.getPath(); // calculates the java.nio.file.Path  
  response.setHeader("Content-Disposition", "attachment; filename=\"" + path.getFileName() + "\"");
  response.setContentLength(Files.size(path);
  Files.copy(path, response.getOutputStream());
  response.flushBuffer();

}