@RequestMapping("/models/{fileId}.smth")
        @ResponseBody
        public HttpEntity<byte[]> getFile(@PathVariable String fileId) throws IOException {
            byte[] model = org.apache.commons.io.FileUtils.readFileToByteArray(new File( "C:/folder/" + fileId + ".smth"));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            headers.setContentLength(model.length);
            return new HttpEntity<byte[]>(model, headers);
        }