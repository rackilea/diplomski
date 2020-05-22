MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>(); 
for(MultipartFile file : multiPartFileList) { 
    ByteArrayResource resource = new ByteArrayResource(file.getBytes()) { 
        @Override 
        public String getFilename() { 
            return ""; 
        } 
    }; 
    data.add("files", resource);
}