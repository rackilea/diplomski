private File getFile() { ... }

@Component(id="downloadLink")
private ActionLink downloadLink;

@OnEvent(component="downloadLink")
private Object handleDownload(){
    final File getFile();
    final OutputStreamResponse response = new OutputStreamResponse() {

        public String getContentType() {
            return "application/pdf"; // or whatever content type your file is
        }

        public void prepareResponse(Response response) {
            response.setHeader ("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        }

        @Override
        public void writeToStream(OutputStream out) throws IOException {
            try {
                InputStream in = new FileInputStream(file);
                IOUtils.copy(in,out);
                in.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }                   
        }
    };
    return response;
}