public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
  GcsFileOptions instance = new Builder().addUserMetadata("timestamp", "01/12/2016").build();
  GcsFilename fileName = getFileName(req);
  GcsOutputChannel outputChannel;
  outputChannel = gcsService.createOrReplace(fileName, instance);
  copy(req.getInputStream(), Channels.newOutputStream(outputChannel));
}