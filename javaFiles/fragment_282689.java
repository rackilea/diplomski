MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
List<ByteArrayResource> files = new ArrayList<>();
for(MultipartFile file : multiPartFileList) {
    files.add(new ByteArrayResource(file.getBytes()));
}
map.put("files", files);